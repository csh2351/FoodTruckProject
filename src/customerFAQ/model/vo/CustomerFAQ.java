package customerFAQ.model.vo;



public class CustomerFAQ {
	
	private int FAQPK;
	private String FAQTitle;
	private String FAQDate;
	private String FAQContent;
	
	public CustomerFAQ(int fAQPK, String fAQTitle, String fAQDate, String fAQContent) {
		super();
		FAQPK = fAQPK;
		FAQTitle = fAQTitle;
		FAQDate = fAQDate;
		FAQContent = fAQContent;
	}

	@Override
	public String toString() {
		return "CustomerFAQ [FAQPK=" + FAQPK + ", FAQTitle=" + FAQTitle + ", FAQDate=" + FAQDate + ", FAQContent="
				+ FAQContent + "]";
	}

	public CustomerFAQ() {
		super();
	}

	public int getFAQPK() {
		return FAQPK;
	}

	public void setFAQPK(int fAQPK) {
		FAQPK = fAQPK;
	}

	public String getFAQTitle() {
		return FAQTitle;
	}

	public void setFAQTitle(String fAQTitle) {
		FAQTitle = fAQTitle;
	}

	public String getFAQDate() {
		return FAQDate;
	}

	public void setFAQDate(String fAQDate) {
		FAQDate = fAQDate;
	}

	public String getFAQContent() {
		return FAQContent;
	}

	public void setFAQContent(String fAQContent) {
		FAQContent = fAQContent;
	}
	
	

}
