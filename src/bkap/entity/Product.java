package bkap.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import bkapinterface.IProduct;

public class Product  implements IProduct , Serializable{
	private static final long serialVersionUID = 1L;
	private String productId;
	private String productName;
	private Category catelog ;
	private String title ;
	private float importPrice ;
	private float exportPrice ;
	private float profit ;
	private String descriptions ;
	private boolean  productStatus ;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(String productId, String productName, Category catelog, String title, float importPrice,
			float exportPrice, float profit, String descriptions, boolean productStatus) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.catelog = catelog;
		this.title = title;
		this.importPrice = importPrice;
		this.exportPrice = exportPrice;
		this.profit = profit;
		this.descriptions = descriptions;
		this.productStatus = productStatus;
	}



	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Category getCatelog() {
		return catelog;
	}

	public void setCatelog(Category catelog) {
		this.catelog = catelog;
	}
	

	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public float getImportPrice() {
		return importPrice;
	}



	public void setImportPrice(float importPrice) {
		this.importPrice = importPrice;
	}



	public float getExportPrice() {
		return exportPrice;
	}



	public void setExportPrice(float exportPrice) {
		this.exportPrice = exportPrice;
	}



	public float getProfit() {
		return profit;
	}



	public void setProfit(float profit) {
		this.profit = profit;
	}



	public String getDescriptions() {
		return descriptions;
	}



	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}



	public boolean isProductStatus() {
		return productStatus;
	}



	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}



	@Override
	public void displayData() {
		// TODO Auto-generated method stub
		System.out.println("Mã sản phẩm"+productId);
		System.out.println("Tên sản phẩm"+productName);
		System.out.println("Title"+title);
		System.out.println("giá nhập"+importPrice);
		System.out.println("giá bán"+exportPrice);
		System.out.println("tên danh mục"+this.catelog.getCatelogName());
		System.out.println("Status :"+(isProductStatus() ? "Hoạt động":"Không hoạt động"));
	}

	@Override
	public void inputData(Scanner sc, List<Category> listCategory,List<Product> listProduct) {
		// TODO Auto-generated method stub
		// check mã sản phẩm
		do {
			try {
				System.out.println("mã sản phẩm ");
				this.productId = sc.nextLine();
				if (this.productId.charAt(0) != 'C' && this.productId.length() != 4 ) {
					System.err.println("Sai cú pháp");
				}else {
					if (this.checkIdEx(listProduct, productId)) {
						System.out.println(productId+"Đã tồn tại");
					}else {
						break;
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Kí tự không đúng");
			}		
			break;
		} while (true);

//		// check tên sản phẩm
		do {
			System.out.println("tên sản phẩm ");
			this.productName = sc.nextLine();
			if (productName.length() < 6 || productName.length() > 50) {
				System.err.println("mời nhập lại ");
			}else {
				if (this.checkIdEx(listProduct, productName)) {
					System.err.println(productName+"tên này đã tồn tại");
				}
				break;
			}
		} while (true);
		// check tiêu đề
		do {
			System.out.println("Nhập vào tiêu đề ");
			this.title = sc.nextLine();
			if (this.title.length() < 6 || this.title.length() > 30 ) {
				System.err.println("Mời nhập lại");
			}else {
				break ;
			}
		break;
		} while (true);
//		check giá nhập sản phẩm
		do {
			System.out.println("Nhập vào giá");
			this.importPrice = Float.parseFloat(sc.nextLine());
				if (this.importPrice <= 0) {
					System.err.println("sai định dạng ");
				}else {
					break;
				}
			
		break;
		} while (true);
//		// check giá bán 
		do {
			System.out.println("giá bán sản phẩm");
			this.exportPrice = Float.parseFloat(sc.nextLine());
				if (this.exportPrice <= this.importPrice + MIN_INTEREST_RATE) {
					System.err.println("Không đúng giá");
				}else {
					break ;
				}
//			break;
		} while (true);
		// check mô tả
		do {
			System.out.println("Nhập vào mô tả ");
			this.descriptions = sc.nextLine();
			if (this.descriptions == "") {
				System.out.println("Không được để trống");
			}else {
				break;
			}
			
		} while (true);
//check  status		
		do {
			System.out.println("Nhập vào trạng thái :");
			String status = sc.nextLine();
			this.productStatus = Boolean.parseBoolean(sc.nextLine());
			if (status.equals("true" )||status.equals( "false")) {
				this.productStatus = Boolean.parseBoolean(status);
				break;
			}else {
				System.err.println("Nhập true hoặc false");
			}
		} while (true);
//		System.out.println("nhập vào mã danh mục ");
//		int maDM = Integer.parseInt(sc.nextLine());
//		this.catelog= this.findCateById(maDM, listCategory);
		//Nhap vao ma danh muc san pham cua san pham
				boolean checkMaDM = false;
				boolean checkW = true;
				do {
					System.out.println("Moi nhap vao ma danh muc");
					int maDM = Integer.parseInt(sc.nextLine());
					for (int i = 0; i < listCategory.size(); i++) {
						if(maDM == listCategory.get(i).getCatelogId()) {
							this.catelog = listCategory.get(i);
							checkMaDM = true;
							checkW = false;
						}
					}
					if(checkMaDM == false) {
						System.err.println("Khong tim thay ma danh muc");
					}
				} while (checkW);
			}
//	}
//	public Category findCateById(int CategoryId,List<Category> listCategory) {
//		Category cate = new Category();
//		for (Category  category : listCategory) {
//			if(CategoryId == category.getCatelogId()) {
//				cate = category ;
//			}
//		}
//		return cate  ;
//	}
	public boolean checkIdEx(List<Product>listProduct,String productId2) {
		boolean check = false ;
		for (Product product : listProduct) {
			if(product.getProductId() == productId2)
			check = true ;
			break ;
		}
		return check ;
		
	}
   
	@Override
	public float calProfit() {
		// TODO Auto-generated method stub
		return this.profit = this.exportPrice - this.importPrice ;
	}

}
