package bkapinterface;

import java.util.List;
import java.util.Scanner;

import bkap.entity.Category;
import bkap.entity.Product;

public interface IProduct {
    float MIN_INTEREST_RATE = (float) 0.2 ;
    public void inputData(Scanner sc ,List<Category> listCategory,List<Product> listProduct);
    public void displayData();	
	public float calProfit();
}
