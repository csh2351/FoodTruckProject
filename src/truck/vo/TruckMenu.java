package truck.vo;

import java.io.Serializable;

public class TruckMenu implements Serializable {

	private static final long serialVersionUID = -7139304683897722923L;
	
	private int menuPk;
	private String menuName;
	private int menuPrice;
	private String menuOimage;
	private String menuRimage;
	
	public TruckMenu() {
		// TODO Auto-generated constructor stub
	}
	
	

	
	public TruckMenu(int menuPk, String menuName, int menuPrice, String menuOimage, String menuRimage) {
		super();
		this.menuPk = menuPk;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuOimage = menuOimage;
		this.menuRimage = menuRimage;
	}

	public int getMenuPk() {
		return menuPk;
	}
	public void setMenuPk(int menuPk) {
		this.menuPk = menuPk;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public String getMenuOimage() {
		return menuOimage;
	}
	public void setMenuOimage(String menuOimage) {
		this.menuOimage = menuOimage;
	}
	public String getMenuRimage() {
		return menuRimage;
	}
	public void setMenuRimage(String menuRimage) {
		this.menuRimage = menuRimage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "TruckMenu [menuPk=" + menuPk + ", menuName=" + menuName + ", menuPrice=" + menuPrice + ", menuOimage="
				+ menuOimage + ", menuRimage=" + menuRimage + "]";
	}
	
	
	
}
