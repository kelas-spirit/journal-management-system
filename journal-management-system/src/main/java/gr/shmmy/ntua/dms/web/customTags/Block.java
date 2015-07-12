package gr.shmmy.ntua.dms.web.customTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Block extends TagSupport {
	Log log = LogFactory.getLog(Block.class);

	private static final long serialVersionUID = 1L;
	private PageContext pageContext;
	private Tag parentTag;
	
	/* Tag attributes */
	private String title;
	private String width;
	private String style;
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setWidth(String width) {
		this.width = width;
	}
	
	public void setStyle(String style) {
		this.style = style;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	@Override
	public void setParent(Tag parentTag) {
		this.parentTag = parentTag;
	}

	@Override
	public Tag getParent() {
		return this.parentTag;
	}

	@Override
	public int doStartTag() throws JspException {
		
		if(title == null){
			title = "&nbsp;";
		}
		
		
		try {
			JspWriter out = pageContext.getOut();
			out.print("<div class=\"BlockBorder\" style='width:"+width+";"+style+"'>");
			out.print("<div class=\"BlockBL\"><div></div></div>");
			out.print("<div class=\"BlockBR\"><div></div></div>");
			out.print("<div class=\"BlockTL\"></div><div class=\"BlockTR\"><div></div></div>");
			out.print("<div class=\"BlockT\"></div><div class=\"BlockR\"><div></div></div>");
			out.print("<div class=\"BlockB\"><div></div></div>");
			out.print("<div class=\"BlockL\"></div><div class=\"BlockC\"></div>");
			out.print("<div class=\"Block\">");
			out.print(" <span class=\"BlockHeader\" style=\"text-align:left;\"><span>"+ title +"</span></span>");
			out.print("<div class=\"BlockContentBorder\">");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.print("</div></div></div>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return EVAL_PAGE;
	}

}
