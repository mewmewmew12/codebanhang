package bkap.run;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import bkap.entity.Category;
import bkap.entity.Product;

public class ShopMangement {
	List<Product> listProduct = new ArrayList<Product>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Category> listCategory = new ArrayList<Category>();
		List<Product> listProduct = new ArrayList<Product>();
		listCategory = ShopMangement.readDMSP("Category.txt");
		listProduct = ShopMangement.readDMSP("Product.txt");
        do {
			System.out.println("********************MENU**************************");
			System.out.println("1. Quản lý danh mục ");
			System.out.println("2. Quản lý sản phẩm ");
			System.out.println("3. Thoát ");
			System.out.println(" Lựa chọn của bạn là : ");
			int luachon = Integer.parseInt(sc.nextLine());
			boolean check = true ;
			switch (luachon) {
			case 1:
				System.out.println("lựa chọn của bạn là 1 : ");
				do {
					System.out.println("***********************quản lý danh mục****************");
					System.out.println("1. Danh sách danh mục ");
					System.out.println("2. Thêm mới danh mục ");
					System.out.println("3. Xóa danh mục ");
					System.out.println("4. Tìm kiếm danh mục ");
					System.out.println("5. Quay lại ");
					System.out.println("luachon của bạn :");
					luachon = Integer.parseInt(sc.nextLine());
					boolean check1 = true ;
					switch (luachon) {
					case 1:
						do {
							System.out.println("***********DANH SÁCH DANH MỤC*********\n");
							System.out.println("1.Hiển thị danh sách dạng cây");
							System.out.println("2.Thông tin chi tiết");
							System.out.println("3.Quay lại ");
							luachon = Integer.parseInt(sc.nextLine());
							
							switch (luachon) {
							case 1:
								System.out.println("Hiển thị danh sách dạng cây :");
								showCategoriesTree(listCategory);
								
								
								break;
							case 2 ://thông tin chi tiết
								System.out.println("nhập tên mã danh mục :");
								String tenDm = sc.nextLine();
								for (Category category : listCategory) {
									if(category.getCatelogName().contains(tenDm)) {
										category.displayData();
									}
								}
								break;
							case 3:
								check1 = false ;
								break ;

							default:
								break;
							}
						} while (check1);			
						break;
					case 2:
						System.out.println(" Thêm mới danh mục");
						System.out.println(" Mời bạn nhập vào số danh mục muốn thêm mới : ");
						int n = Integer.parseInt(sc.nextLine());
						for (int i = 0; i < n ; i++) {
							Category category = new Category();
							category.inputData(sc, listCategory);
							listCategory.add(category);		
						}						
						break;
					case 3 :// xóa danh mục		
						System.out.println("xóa danh mục");
						deleteCategory(listCategory, listProduct);
						break;
					case 4 :
						System.out.println("Tìm kiếm danh mục ");
						System.out.println("Nhập vào tên danh mục ");
						String ten = sc.nextLine();
						for (Category category : listCategory) {
							if (category.getCatelogName().indexOf(ten) >= 0) {
								category.displayData();
							}
						}
						break ;
					case 5 :
						check = false ;
						break;

					default:
						break;
					}
				} while (check);
				break ;
			case 2 ://Thực hiện chức năng  2
				
				do {
					System.out.println("=====================QUẢN LÝ SẢN PHẨM====================");
					System.out.println("1. Thêm sản phẩm mới ");
					System.out.println("2. Tính lợi nhuận sản phẩm");
					System.out.println("3. Hiển thị thông tin sản phẩm ");
					System.out.println("4. Sắp xếp sản phẩm ");
					System.out.println("5. Cập nhật thông tin sản phẩm");
					System.out.println("6. Cập nhật trạng thái sản phẩm ");
					System.out.println("7. Quay lại ");
					luachon = Integer.parseInt(sc.nextLine());
					switch (luachon) {
					case 1:
						System.out.println("Nhập vào số sản phẩm muốn thêm ");
						int m = Integer.parseInt(sc.nextLine());
						for (int i = 0; i < m ; i++) {
							System.out.println("sản phẩm thứ"+(i+1));
							Product product = new Product();
							product.inputData(sc, listCategory, listProduct);
							listProduct.add(product);
						}
						break;
					case 2 :
						System.out.println("tính lợi nhuận sản phẩm");
						for (Product product : listProduct) {
							product.calProfit();
						}
						
						break;
					case 3 :
						System.out.println("Hiển thị thông tin sản phẩm");
						boolean check2 = true ;
						do {
							System.out.println("==================THÔNG TIN SẢN PHẨM====================");
							System.out.println("1.Hiển thị sản phẩm theo danh mục");
							System.out.println("2.Hiển thị chi tiết sản phẩm");
							System.out.println("3.Quay lại");
							luachon = Integer.parseInt(sc.nextLine());
							
							switch (luachon) {
							case 1:
								System.out.println("Nhập vào danh mục sản phẩm muốn in");
//								System.out.println("Nhập vào mã danh mục sản phẩm");
//								String maDM = sc.nextLine();
//								for (Product product : listProduct) {
//									for (Category category : listCategory) {
//										if (maDM ==) {
//											System.out.println("tên danh mục"+this.catelog.getCatelogName());
//										}
//									}
//								}	
//								
								System.out.println("Nhap vao danh ma muc san pham muon xem");
								int maDM = Integer.parseInt(sc.nextLine());
								boolean checkMaDM = false;
								for (Product product : listProduct) {
									if (product.getCatelog().getCatelogId() == maDM) {
										product.displayData();
										checkMaDM = true;
									}
								}
								if(checkMaDM == false) {
									System.err.println("Khong tim thay ma danh muc");
								}
								break;
							
								
							case 2:
								System.out.println("Hiển thị chi tiết sản phẩm ");
								System.out.println("Nhập vào ID sản phẩm");
								String iDsanpham = sc.nextLine();
								for (Product product : listProduct) {
									if (product.getProductId().compareTo(iDsanpham) == 0 ) {
										product.displayData();
									}
									
								}
								break;
							case 3:
								check2 = false ;
                                break;
							default:
								break;
							}
						}while(check2);
						break;
					case 4 :
						System.out.println("Sắp xếp sản phẩm");
						boolean check3 = true ;
						do {
							System.out.println("****************SẮP XẾP SẢN PHẨM***************");
							System.out.println("1.Sắp xếp sản phẩm theo giá suất tăng dần");
							System.out.println("2.Sắp xếp sản phẩm theo lợi nhuận giảm dần");
							System.out.println("3.Quay lại ");
							luachon = Integer.parseInt(sc.nextLine());
							switch (luachon) {
							case 1:
								System.out.println("Sắp xếp sản phẩm theo giá suất tăng dần");
								sortByPrice(listCategory, listProduct);
								for (Product product : listProduct) {
									
									product.displayData();
								}
								break;
							case 2:
								System.out.println("Sắp xếp sản phẩm theo lợi nhuận giảm dần");
								sortByProfit(listCategory, listProduct);
								for (Product product : listProduct) {
									product.displayData();
								}
								break;
							case 3 :
								check3 = false ;
								break;
							default:
								break;
							}
						} while (check3);
						break;
					case 5:
						System.out.println("Nhập vào mã sản phẩm ");
						String maSP = sc.nextLine();
						for (Product product : listProduct) {
							if (product.getProductId().compareTo(maSP) == 0) {
								System.out.println("Cập nhật thông tin sản phẩm ");
//								System.out.println("Cập nhật tên sản phẩm ");
//								String Name = sc.nextLine();
								luachon = Integer.parseInt(sc.nextLine());
								switch (luachon) {
								case 1:
									System.out.println("Cập nhật tên sản phẩm ");
									String name = sc.nextLine();
									product.setProductName(name);
									break;
								case 2 :
									System.out.println("Cập nhật tiêu đề");
									String tieuDe = sc.nextLine();
									product.setTitle(tieuDe);
								case 3:
									System.out.println("Cập nhật giá nhập");
									float giaNhap = Float.parseFloat(sc.nextLine());
									product.setImportPrice(giaNhap);
								case 4:
									System.out.println("Cập nhật giá bán ");
									float giaBan = Float.parseFloat(sc.nextLine());
									product.setExportPrice(giaBan);

								default:
									break;
								}
								
							}
						}
						
						break;
					case 6:
						System.out.println("Nhập vào mã sản phẩm");
						String maSP1 = sc.nextLine();
						for (Product product : listProduct) {
							System.out.println("Nhập vào trạng thái cần sửa");
							if (product.getProductId().compareTo(maSP1)== 0) {
								boolean Status = Boolean.parseBoolean(sc.nextLine());
								product.setProductStatus(Status);
							} 
						}
						break;
					case 7 :
                     check = false ;
                     break;
					default:
						break;
					}
				} while (check);
				break ; 
			case 3 :
				ShopMangement.writeDMSP("Category.txt", listCategory);
				ShopMangement.writeDMSP("Product.txt", listProduct);
				System.exit(0);
				break ;

			default:
				break;
			}
		} while (true);
	}
	public static void showCategoriesTree(List<Category> listCategory) {
		int stt = 0;
		for (Category category : listCategory) {
			if(category.getParentId()==0) {
				stt++;
				System.out.printf("%d %s\n",stt, category.getCatelogName());
				int stt2 = 0;
				for (Category category2 : listCategory) {
					if(category2.getParentId()== category.getCatelogId()) {
						stt2++;
						System.out.printf("\t%d.%d %s-maDm %d\n",stt,stt2, category2.getCatelogName(),category2.getCatelogId());
						int stt3 = 0;
						for (Category category3 : listCategory) {
							if(category3.getParentId() == category2.getCatelogId()) {
								stt3++;
								System.out.printf("\t\t%d.%d.%d %s-maDm %d\n",stt,stt2,stt3, category3.getCatelogName(),category3.getCatelogName());
							}
						}
					}
				}
			}
		}
	}
	// sắp xếp tăng dần 
	public static void sortByPrice(List<Category> listCategory,List<Product> listProduct) {
		listProduct.sort(new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				// TODO Auto-generated method stub
				return  (int) (o1.getImportPrice() - o2.getImportPrice()) ;
			}
		});
	}
	// sắp xếp lợi nhuận giảm dần 
	public static void sortByProfit(List<Category> listCategory,List<Product> listProduct) {
		listProduct.sort(new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				// TODO Auto-generated method stub
				return  (int) (o2.getProfit() - o2.getProfit()) ;
			}
		});
	}
	// xóa dữ liệu
	public static void deleteCategory(List<Category> listCategory,List<Product> listProduct) {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhập vào mã danh mục cần xóa");
		Integer Mdm = Integer.parseInt(sc.nextLine());
		// check xem co san pham hay ko
		boolean check = false ;
		for (Product product : listProduct) {
			if (product.getCatelog().getCatelogId() == Mdm ) {
				check = false ;
				System.out.println("danh mục bạn xóa đang có sản phẩm ");
			}
		}
		for (int i = 0; i < listCategory.size(); i++) {
			if (listCategory.get(i).getCatelogId() == Mdm) {
				listCategory.remove(i);
			}
		}
		
	}
	public static <T> void  writeDMSP(String path , List<T> list) {
		try {
			FileOutputStream outputStream = new FileOutputStream(path);
			try {
				ObjectOutputStream stream = new ObjectOutputStream(outputStream);
				stream.writeObject(list);
				outputStream.close();
				stream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println(e);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	public static <T> List<T>  readDMSP(String path) {
		List<T> listCate = new ArrayList<T>();
		try {
			FileInputStream inputStream = new FileInputStream(path);
		
			ObjectInputStream stream = new ObjectInputStream(inputStream);
			
			 listCate = (List<T>) stream.readObject();
			return listCate;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listCate;
		
	}

}