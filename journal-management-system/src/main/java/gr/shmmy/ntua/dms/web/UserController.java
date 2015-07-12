package gr.shmmy.ntua.dms.web;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import gr.shmmy.ntua.dms.dao.UserDao;
import gr.shmmy.ntua.dms.domain.Article;
import gr.shmmy.ntua.dms.domain.Category;
import gr.shmmy.ntua.dms.domain.Comment;
import gr.shmmy.ntua.dms.domain.Coupon;
import gr.shmmy.ntua.dms.domain.Metadata;
import gr.shmmy.ntua.dms.domain.MetadataRange;
import gr.shmmy.ntua.dms.domain.Subscription;
import gr.shmmy.ntua.dms.domain.User;
import gr.shmmy.ntua.dms.service.ArticleService;
import gr.shmmy.ntua.dms.service.CategoryService;
import gr.shmmy.ntua.dms.service.CommentService;
import gr.shmmy.ntua.dms.service.CouponService;
import gr.shmmy.ntua.dms.service.DocumentService;
import gr.shmmy.ntua.dms.service.MetadataRangeService;
import gr.shmmy.ntua.dms.service.SubscriptionService;
import gr.shmmy.ntua.dms.service.UserService;
import gr.shmmy.ntua.dms.web.formBean.CouponPostFormBean;
import gr.shmmy.ntua.dms.web.formBean.DocumentPostFormBean;
import gr.shmmy.ntua.dms.web.formBean.UserPostBean;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private MetadataRangeService metadataRangeService;
	
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SubscriptionService subscriptionService ;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private CouponService couponService;
	
	
	@RequestMapping(value="/subscribed",method = RequestMethod.GET)
    public ModelAndView subscribed(Authentication auth) throws SQLException, UnsupportedEncodingException{
    	ModelAndView mav = new ModelAndView();
    	
    	List<Metadata> lst = documentService.getDocumentList();
    	List<DocumentPostFormBean> doc = new ArrayList<DocumentPostFormBean>();
    	
    	List<Category> categorylist = categoryService.getCategoryList();
    	
    	Long userId = userService.getIdByUsername(auth.getName());
    	
    	for(Metadata metadata: lst) {
    		
    	  if(subscriptionService.SubscriptionExist(metadata.getMetadataId(), userId)){
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
    	}
    	
    	mav.addObject("categorylist", categorylist);
    	mav.addObject("doc", doc);
    	mav.addObject("userId", userId);
    
    	mav.setViewName("subscribed");	
    	return mav;
    }
	
	@RequestMapping(value="/nosubscribed",method = RequestMethod.GET)
    public ModelAndView nosubscribed(Authentication auth) throws SQLException, UnsupportedEncodingException{
    	ModelAndView mav = new ModelAndView();
    	
    	List<Metadata> lst = documentService.getDocumentList();
    	List<DocumentPostFormBean> doc = new ArrayList<DocumentPostFormBean>();
    	
    	int count = 0;
    	
    	List<Category> categorylist = categoryService.getCategoryList();
    	
    	Long userId = userService.getIdByUsername(auth.getName());
    	
    	for(Metadata metadata: lst) {
    		
    	  if(!(subscriptionService.SubscriptionExist(metadata.getMetadataId(), userId))){
    		  
    		  count++;
    		  
    		  
    		  
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
    	}
    	
    	
    	mav.addObject("count", count);
    	mav.addObject("categorylist", categorylist);
    	mav.addObject("doc", doc);
    
    	mav.setViewName("nosubscribed");	
    	return mav;
    }
	
	@RequestMapping(value="/commentcreate",method = {RequestMethod.GET,RequestMethod.POST})
	   public ModelAndView userComment(Authentication auth, @RequestParam("articleId") Long articleId,
			   @RequestParam("text") String text){
		   ModelAndView mav = new ModelAndView();
		   Long userId = userService.getIdByUsername(auth.getName());
		   Comment comment = new Comment();
		   comment.setArticleId(articleId);
		   comment.setUsername(auth.getName());
		   comment.setComment_text(text);
		   comment.setUserId(userId);
		   
		   commentService.saveComment(comment);
		   
		   Article article = articleService.getArticleById(articleId);
		   List<Comment> com = commentService.getCommentById(articleId);
		   mav.addObject("art", article);
		   mav.addObject("com", com);
			 mav.setViewName("articlefullpage");
		  
		   return mav;
	   }
	
	@RequestMapping(value="/deletedsubscription",method = RequestMethod.GET)
	 public ModelAndView deleteSubscription( @RequestParam("id") Long id, @RequestParam("usId") Long userId){
		 ModelAndView mav = new ModelAndView();
		 
		 subscriptionService.deleteByUserAndDocument(userId,id);
		 mav.setViewName("redirect:/subscribed");
		 return mav;
	 }
	
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public ModelAndView processUserListView(){
		
		
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("users", userService.getAllUsers());
		mav.setViewName("users");
		return mav;
		
	}
	
	@RequestMapping(value = "/searchuser", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView searchUser(@RequestParam("q") String searchUserQuery){
		
		ModelAndView mav = new ModelAndView();
		List<User> usq = userService.getUserBySearchQuery(searchUserQuery);

		mav.addObject("usq", usq);
		
		mav.addObject("q",searchUserQuery);
		mav.setViewName("userSearch");
		return mav;
	}
	

	@RequestMapping(value = "/couponsend", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView usersCoupon( @RequestParam("userId") Long userId){
		ModelAndView mav = new ModelAndView();
		
		 List<Category> categorylist = categoryService.getCategoryList();
		 mav.addObject("categorylist", categorylist);
		mav.addObject("userId", userId);
		mav.setViewName("couponSend");		
		return mav;
	}
	
	
	@RequestMapping(value = "/couponresult", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView couponResult(@RequestParam("userId") Long userId,
			@RequestParam("selectedCategory")int selectedCategory,
			@RequestParam("coupon")Long coupon){
		ModelAndView mav = new ModelAndView();
		String result=" ";
		
		Coupon coup = new Coupon();
	
		
		if(couponService.couponExist(userId, selectedCategory)==true){
			result="Already exist for current category";
		}else{
			
			coup.setCouponNumber(coupon);
			coup.setCategoryId(selectedCategory);
			coup.setUserId(userId);
			
			couponService.saveCoupon(coup);
			result="Successfully  saved!!!";
		}
		
		mav.addObject("result", result);
		mav.setViewName("couponResult");
		
		return mav;
	}
	
	@RequestMapping(value = "/couponlist", method = RequestMethod.GET)
	public ModelAndView getCouponList(Authentication auth){
		ModelAndView mav = new ModelAndView();
		Long userId = userService.getIdByUsername(auth.getName());
		List<Coupon> coupon = couponService.getCouponById(userId);
		List<CouponPostFormBean> cpfb = new ArrayList<CouponPostFormBean>();
		//String categoryName="";
		for(Coupon cap: coupon){
			categoryService.getCategoryById(cap.getCategoryId());
			cpfb.add(new CouponPostFormBean(categoryService.getCategoryById(cap.getCategoryId()),cap.getCouponNumber()));
		}
		
		mav.addObject("coupon", cpfb);
		mav.setViewName("couponlist");
		
		return mav;
	}
	
	@RequestMapping(value = "/subscribeprepear", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView prepareSubscribe(Authentication auth,
			@RequestParam("documentid")Long documentid,
			@RequestParam("count")int count){
		
		
		System.out.println("documentid: "+documentid);
		
		boolean ekptwsi = false;
		ModelAndView mav = new ModelAndView();
		Long userId = userService.getIdByUsername(auth.getName());
		Metadata metadata = documentService.getDocumentById(documentid);
		
		Double couponPrice = metadata.getMetadata_web_price() /2.0;
		Double price = metadata.getMetadata_web_price();
		
		//apo dw epipleon ekptwseis an exei
		
		//System.out.println("count: "+count);
		
		if((count >= 6) && (count < 12)){
			ekptwsi = true;
			price= (price / 100.0) * 90.0 ;
		}
		if( count >= 12){
			ekptwsi = true;
			price= (price / 100.0) * 80.0 ;
		}
		
		if(price <  metadata.getMetadata_web_price()){
			price =  metadata.getMetadata_web_price() / 2 ;
		}
		
		System.out.println("---> "+metadata.getCategoryId());
		List<Metadata> lst = documentService.getDocumentListByCategoryId(metadata.getCategoryId());
		
		
		for(Metadata data: lst){
			System.out.println("-> "+data.getMetadataId());
			if(subscriptionService.SubscriptionExist(data.getMetadataId(), userId)==true){
				ekptwsi = true;
				price= (price / 100.0) * 95.0;
			}
		}
		
		price =Double.parseDouble(new DecimalFormat("##.####").format(price));		
		mav.addObject("ekptwsi", ekptwsi);
		mav.addObject("price", price);
		mav.addObject("couponPrice", couponPrice);
		mav.addObject("userId", userId);
		mav.addObject("document", metadata);
		mav.setViewName("subscribeprepear");
		return mav;
	}
	
	
	@RequestMapping(value = "/subscriberesult", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView sendSubscribe(@RequestParam("metadataId")Long metadataId,
			@RequestParam("categoryId")int categoryId,
			@RequestParam("userId")Long userId,
			@RequestParam("coupon")Long coupon){
		ModelAndView mav = new ModelAndView();
		Subscription subscr = new Subscription();
		
		String status = " ";
		
		if(couponService.couponExist(userId, categoryId, coupon)==true){
			subscr.setMetadataId(metadataId);
			subscr.setUserId(userId);
			subscriptionService.saveSubscription(subscr);
			status="Successfully saved!";
		}else{
			status="Somthing wrong. Maybe the coupon code is invalid. Try again.";
		}
		
		mav.addObject("status", status);
		mav.setViewName("subscriberesult");
		
		return mav;
	}
	
	@RequestMapping(value = "/subresult", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView subresult(@RequestParam("metadataId")Long metadataId,
			@RequestParam("userId")Long userId
			){
		ModelAndView mav = new ModelAndView();
		Subscription subscr = new Subscription();
		
		String status = " ";
		
			subscr.setMetadataId(metadataId);
			subscr.setUserId(userId);
			subscriptionService.saveSubscription(subscr);

			status="Successfully saved!";
		
		
		mav.addObject("status", status);
		mav.setViewName("subscriberesult");
		
		return mav;
	}
	
	@RequestMapping(value="/subcourier",method = RequestMethod.GET)
	 public ModelAndView courier( ){
		 ModelAndView mav = new ModelAndView();
		 
		 mav.setViewName("courier");
		 return mav;
	 }

	
	@RequestMapping(value="/public/registration", method = RequestMethod.GET)
	public ModelAndView publicUserRegForm(){
		ModelAndView mav = new ModelAndView();
		System.out.println("I'm Here");
		
		mav.setViewName("Registration");
		return mav;
	}
	
	@RequestMapping(value="/public/registration", method = RequestMethod.POST)
	public ModelAndView publicUserRegFormPost(
			@RequestParam("Name")String firstname,
			@RequestParam("LastName")String lastname,
			@RequestParam("User")String username,
			@RequestParam("Email")String email,
			@RequestParam("Password")String password
			){
		ModelAndView mav = new ModelAndView();
		UserPostBean userbean= new UserPostBean();
		userbean.setFirstname(firstname);
		userbean.setLastname(lastname);
		userbean.setUsername(username);
		userbean.setEmail(email);
		userbean.setPassword(password);
		
		boolean userExist= userService.userExist(username);
		if(userExist==true){
			mav.setViewName("RegistrationError");
		}else{
		
		
		userService.inserFromPublicReg(userbean);
		
		mav.setViewName("redirect:/index");
		}
		return mav;
	}
	
	
}
