package gr.shmmy.ntua.dms.web;

import gr.shmmy.ntua.dms.domain.Article;
import gr.shmmy.ntua.dms.domain.Category;
import gr.shmmy.ntua.dms.domain.Comment;
import gr.shmmy.ntua.dms.domain.Metadata;
import gr.shmmy.ntua.dms.domain.MetadataRange;
import gr.shmmy.ntua.dms.service.ArticleService;
import gr.shmmy.ntua.dms.service.CategoryService;
import gr.shmmy.ntua.dms.service.CommentService;
import gr.shmmy.ntua.dms.service.DocumentService;
import gr.shmmy.ntua.dms.service.MetadataRangeService;
import gr.shmmy.ntua.dms.web.formBean.DocumentPostFormBean;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.codec.binary.Base64;

import java.util.List;


@Controller
public class DocumentController {
	
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private MetadataRangeService metadataRangeService;
	
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private CommentService commentService;
	
	
    public MetadataRangeService getMetadataRangeService() {
		return metadataRangeService;
	}

	public void setMetadataRangeService(MetadataRangeService metadataRangeService) {
		this.metadataRangeService = metadataRangeService;
	}

	public  CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	List<DocumentPostFormBean> dpfb;
	

	@RequestMapping(value="/",method = RequestMethod.GET)
	    public ModelAndView welcome(){
	    	ModelAndView mav = new ModelAndView();
	    	mav.setViewName("welcome");	
	    	return mav;
	    }
	
	@RequestMapping(value="/changecategory",method = RequestMethod.GET)
	public ModelAndView selectedcatGet(){
		
		List<Category> categorylist = categoryService.getCategoryList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("categorylist", categorylist);
    	mav.addObject("doc", dpfb);
    	mav.setViewName("changecategory");
		
		return mav;
		
	}
	
	@RequestMapping(value="/deletedocument",method = RequestMethod.GET)
	public ModelAndView deleteDocument(@RequestParam("id") Long id,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap){
		
		documentService.deleteDocument(id);
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:/index");

		return mav;
	}
	
	@RequestMapping(value="/changecategory",method = RequestMethod.POST)
	public ModelAndView selectedcat(@RequestParam("selectedCategory")int selectedCategory) throws SQLException, UnsupportedEncodingException{
		
		List<Metadata> lst = documentService.getDocumentListByCategoryId(selectedCategory);
		dpfb = new ArrayList<DocumentPostFormBean>();
		for(Metadata metadata: lst) {
    		Blob blob =	metadata.getMetadata_cover_photo();
    		byte[]	blobAsBytes = blob.getBytes(1, (int) blob.length());
    		byte[] encodeBase64=Base64.encodeBase64(blobAsBytes);
			String base64Encoded = new String(encodeBase64, "UTF-8");
			
			String categoryName = categoryService.getCategoryById(metadata.getCategoryId());
			
			dpfb.add(new DocumentPostFormBean(metadata.getMetadataId(),metadata.getMetadataName(),metadata.getMetadata_date(),
					metadata.getMetadata_out_price(),metadata.getMetadata_web_price(), base64Encoded, metadata.getMetadata_edition(),
					categoryName, metadata.getCategoryId(),
					metadata.getMetadata_range_id(),metadata.getSize()));
			
    	}
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/changecategory");	
		
		return mav;
		

	}
	    
	   @RequestMapping(value="/index",method = RequestMethod.GET)
	    public ModelAndView index(Authentication auth) throws SQLException, UnsupportedEncodingException{
	    	ModelAndView mav = new ModelAndView();
	    	
	    	List<Metadata> lst = documentService.getDocumentList();
	    	List<DocumentPostFormBean> doc = new ArrayList<DocumentPostFormBean>();
	    	
	    	List<Category> categorylist = categoryService.getCategoryList();
	    	
	    	for(Metadata metadata: lst) {
	    		Blob blob =	metadata.getMetadata_cover_photo();
	    		byte[]	blobAsBytes = blob.getBytes(1, (int) blob.length());
	    		byte[] encodeBase64=Base64.encodeBase64(blobAsBytes);
				String base64Encoded = new String(encodeBase64, "UTF-8");
				
				String categoryName = categoryService.getCategoryById(metadata.getCategoryId());
				
				doc.add(new DocumentPostFormBean(metadata.getMetadataId(),metadata.getMetadataName(),metadata.getMetadata_date(),
						metadata.getMetadata_out_price(),metadata.getMetadata_web_price(), base64Encoded, metadata.getMetadata_edition(),
						categoryName, metadata.getCategoryId(),
						metadata.getMetadata_range_id(),metadata.getSize()));
				
	    	}
	    	
	    	mav.addObject("categorylist", categorylist);
	    	mav.addObject("doc", doc);
	    
	    	mav.setViewName("index");	
	    	return mav;
	    }
	   
	   
	   @RequestMapping(value="/upload",method = RequestMethod.POST)
	    public ModelAndView upload(Authentication auth, 
	    		@RequestParam("name")String name,
	    		@RequestParam("out_price")Double out_price,
	    		@RequestParam("web_price")Double web_price, //selectedCategory
	    		@RequestParam("selectedCategory")int selectedCategory,
	    		@RequestParam("selectedRange")int selectedRange,
	    		@RequestParam(value = "document", required = true) MultipartFile document) throws SerialException, SQLException{
		   
		   
		   ModelAndView mav = new ModelAndView();
		   Metadata metadata = new Metadata();
	    	
				
		    	
		    	
		    	metadata.setCategoryId(selectedCategory);
		    	metadata.setMetadata_range_id(selectedRange);
		    //	metadata.setMetadata_cover_photo(blob);
		    	metadata.setMetadataName(name);
		    	metadata.setMetadata_edition(1.0);  //create for first time
		    	metadata.setMetadata_out_price(out_price);
		    	metadata.setMetadata_web_price(web_price);
		     	metadata.setMetadata_date(new Date());
		     	metadata.setSize(document.getSize());
		    	
		    	System.out.println("ok prin");
		    	
		    	documentService.saveDocument(document, metadata);
		    	
		    	//metadataDao.insertIntoMetadata(name,selectedCategory);
		    	
		    //	metadataDao.save(metadata);
		    	System.out.println("ok meta");

			
	    	
	    	
	    	
	    	mav.setViewName("redirect:/index");	
	    	
	    	return mav;
	    }
	   
	   @RequestMapping(value="/upload",method = RequestMethod.GET)
	   public ModelAndView upload(){
		   ModelAndView mav = new ModelAndView();
		   
		   List<Category> categorylist = categoryService.getCategoryList();
		   List<MetadataRange> rangelist = metadataRangeService.getAllRange();
		   
		   //metadataRangeDao.findAll();
		   mav.addObject("rangelist", rangelist);
		  mav.addObject("categorylist", categorylist);
		   mav.setViewName("createMagazine");
		   return mav;
	   }
	   
	   @RequestMapping(value="/articlelist",method = {RequestMethod.POST, RequestMethod.GET})
	   public ModelAndView articlelist( @RequestParam("documentid") Long documentid){
		   ModelAndView mav = new ModelAndView();  
		   
		 List<Article> art =   articleService.getArticlesById(documentid);
		 
		 mav.addObject("documentId", documentid);
		 mav.addObject("article", art);
		 mav.setViewName("articlelist");
		   
		   return mav;
	   }
	   
	   @RequestMapping(value="/articlecreate",method = {RequestMethod.POST, RequestMethod.GET})
	   public ModelAndView articlecreate( @RequestParam("documentid") Long documentid){
		   ModelAndView mav = new ModelAndView();  
		   
		// List<Article> art =   articleService.getArticlesById(documentid);
		 mav.addObject("documentId", documentid);
		// mav.addObject("article", art);
		 mav.setViewName("articlecreate");
		   
		   return mav;
	   }
	   
	   @RequestMapping(value="/artcreate",method = {RequestMethod.POST, RequestMethod.GET})
	   public ModelAndView artecreate( @RequestParam("documentid") Long documentid,
			   @RequestParam("subject") String subject,
			   @RequestParam("text") String text,
			   Authentication auth) {
		   ModelAndView mav = new ModelAndView();  
		   
		  Article article = new Article();
		  article.setArticleSubject(subject);
		  article.setArticleText(text);
		  article.setMetadataId(documentid);
		  article.setOwner(auth.getName());
		  
		  articleService.saveArticle(article);
		   
		 List<Article> art =   articleService.getArticlesById(documentid);
		 mav.addObject("documentId", documentid);
		 mav.addObject("article", art);
		 mav.setViewName("articlelist"); 
		   return mav;
	   }
	   
	   @RequestMapping(value="/articlefullpage",method = {RequestMethod.POST, RequestMethod.GET})
	   public ModelAndView articlefullpage( @RequestParam("articleId") Long articleId){
		   
		   
		   ModelAndView mav = new ModelAndView();  	   
		   Article article = articleService.getArticleById(articleId);
		   List<Comment> com = commentService.getCommentById(articleId);
		// List<Article> art =   articleService.getArticlesById(documentid);
		// mav.addObject("documentId", documentid);
		 mav.addObject("art", article);
		 mav.addObject("com", com);
		 mav.setViewName("articlefullpage");
		   
		   return mav;
	   }
	
}
