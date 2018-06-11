package truck.vo;

import java.io.Serializable;

public class TruckMenu implements Serializable {

	private static final long serialVersionUID = -7139304683897722923L;
	
	private int menuPk;
	private String menuName;
	private int menuPrice;
	private String menuImage;
	
	public TruckMenu() {

	}
	
	
	public TruckMenu(int menuPk, String menuName, int menuPrice, String menuImage) {
		super();
		this.menuPk = menuPk;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuImage = menuImage;
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
	public String getMenuImage() {
		return menuImage;
	}
	public void setMenuImage(String menuImage) {
		this.menuImage = menuImage;
	}
	@Override
	public String toString() {
		return "TruckMenu [menuPk=" + menuPk + ", menuName=" + menuName + ", menuPrice=" + menuPrice + ", menuImage="
				+ menuImage + "]";
	}
	
}
