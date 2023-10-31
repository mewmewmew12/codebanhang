package bkap.entity;

import java.io.Serializable;
import java.security.PublicKey;
import java.util.List;
import java.util.Scanner;

import bkapinterface.ICategorige;


public  class Category implements ICategorige , Serializable {
	private static final long serialVersionUID = 1L;
    private int catelogId ;
    private String catelogName ;
    private String desscription;
    private int parentId;
    private boolean catelogStatus ;
    
	public Category(int catelogId, String catelogName, String desscription, boolean catelogStatus, int parentId) {
		super();
		this.catelogId = catelogId;
		this.catelogName = catelogName;
		this.desscription = desscription;
		this.parentId = parentId;
		this.catelogStatus = catelogStatus;
	}
	
    public Category() {
		// TODO Auto-generated constructor stub
	}
    
	public int getCatelogId() {
		return catelogId;
	}

	public void setCatelogId(int catelogId) {
		this.catelogId = catelogId;
	}

	public String getCatelogName() {
		return catelogName;
	}

	public void setCatelogName(String catelogName) {
		this.catelogName = catelogName;
	}

	public String getDesscription() {
		return desscription;
	}

	public void setDesscription(String desscription) {
		this.desscription = desscription;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int prentId) {
		this.parentId = parentId;
	}
	


	public boolean isCatelogStatus() {
		return catelogStatus;
	}

	public void setCatelogStatus(boolean catelogStatus) {
		this.catelogStatus = catelogStatus;
	}

	@Override
	public void displayData() {
		// TODO Auto-generated method stub
		System.out.println("id  :"+catelogId);
		System.out.println("Name :"+catelogName);
		System.out.println("prentId :"+parentId);
		System.out.println("Status :"+(isCatelogStatus() ? "Hoạt động":"Không hoạt động"));
	}
	// kiểm tra id đã tồn tại hay chưa 
	

	@Override
	public void inputData(Scanner sc, List<Category> listCategory) {
		// TODO Auto-generated method stub
		// check mã đúng định dạng 
		do {
//			System.out.println("Nhập vào mã danh mục ");
//			this.catelogId = Integer.parseInt(sc.nextLine());
			try {
				System.out.println("Nhập vào mã danh mục ");
				this.catelogId = Integer.parseInt(sc.nextLine());
				if(this.catelogId <= 0) {
					System.err.println("sai định dạng");
				} else {
					// check điều kiện 
					if (this.checkIdEx(listCategory, catelogId)) {
						System.err.println(catelogId+"đã tồn tại");
					}else {
						break;
					}					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("ko phải số nguyên ");
			}
//			if(this.catelogId <= 0) {
//				System.err.println("sai định dạng");
//			} else {
//				// check điều kiện 
//				if (this.checkIdEx(listCategory, catelogId)) {
//					System.err.println(catelogId+"đã tồn tại");
//				}else {
//					break;
//				}
//				break;
//			}
		// check độ dài kí tự	
		} while (true);
//		System.out.println("Nhập vào tên danh mục");
//	     this.catelogName = sc.nextLine();
		do {
			System.out.println("Nhập vào tên danh mục");
			this.catelogName = sc.nextLine();
			if(this.catelogName.length() < 6 ) {
				System.err.println("sai định dạng");
			}else {
				break;
			}
		} while (true);
//		System.out.println("nhập vào trạng thái danh mục ");
		//check mô tả 
		do {
			System.out.println("Nhập vào mô tả danh mục :");
			this.desscription = sc.nextLine();
			if(this.desscription == "" || this.desscription.isEmpty()) {
				System.err.println("Không được để trống ");
			}else {
				break ;
			}
			
		} while (true);
		// check trạng thái 
		do {
			System.out.println("Nhập vào trạng thái :");
			String status = sc.nextLine();
			this.catelogStatus = Boolean.parseBoolean(sc.nextLine());
			if (status.equals("true" )||status.equals( "false")) {
				this.catelogStatus = Boolean.parseBoolean(status);
				break;
			}else {
				System.err.println("Nhập true hoặc false");
			}
		} while (true);
		// check danh mục 
		do {
			System.out.println("Nhập vào mã danh mục cha :");
			this.parentId = Integer.parseInt(sc.nextLine());
			if(this.checkIdEx(listCategory, this.parentId) && this.parentId > 0 ) {
				break;
			}else {
				if (this.parentId == 0 ) {
					break ;
				}else {
					System.err.println("Danh mục cha không tồn tại ");
				}
			}
			
		} while (true);
		
		
	}
	public boolean checkIdEx(List<Category>listCategory,int maDM) {
		boolean check = false ;
		for (Category category : listCategory) {
			if(category.getCatelogId() == maDM)
			check = true ;
			break ;
		}
		return check ;
		
	}
	
    
}
