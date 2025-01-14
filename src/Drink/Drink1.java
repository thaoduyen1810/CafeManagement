package Drink;

import java.sql.Date;

public class Drink1 {
public String douong;
double thanhtien;
public double giatien;
public int soluong;
Date date;
public Drink1(String douong, double giatien, int soluong, double thanhtien) {
	super();
	this.douong = douong;
	this.giatien = giatien;
	this.soluong = soluong;
	this.thanhtien = thanhtien;
}

public Drink1(String douong, double giatien, int soluong, double thanhtien, Date date) {
	super();
	this.douong = douong;
	this.thanhtien = thanhtien;
	this.giatien = giatien;
	this.soluong = soluong;
	this.date = date;
}

public String getDouong() {
	return douong;
}
public void setDouong(String douong) {
	this.douong = douong;
}
public double getThanhtien() {
	return thanhtien;
}
public void setThanhtien(double thanhtien) {
	this.thanhtien = thanhtien;
}
public double getGiatien() {
	return giatien;
}
public void setGiatien(double giatien) {
	this.giatien = giatien;
}
public int getSoluong() {
	return soluong;
}
public void setSoluong(int soluong) {
	this.soluong = soluong;
}

}
