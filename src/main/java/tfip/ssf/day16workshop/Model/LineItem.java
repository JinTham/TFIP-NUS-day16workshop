package tfip.ssf.day16workshop.Model;

import jakarta.json.JsonObject;

public class LineItem {
    private String item;
    private int quantity;

    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

	 public static LineItem create(JsonObject json) {
		 LineItem lineItem = new LineItem();
		 lineItem.setItem(json.getString("item"));
		 lineItem.setQuantity(json.getInt("quantity"));
		 return lineItem;
	 }
}
