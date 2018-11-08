package com.example.fathanauzan.aplikasipemesanan;

import android.app.assist.AssistStructure;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import static android.R.string.no;
import static android.os.Build.VERSION_CODES.N;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void increment(View view){//perintah tombol tambah
        if(quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1 ;
        display(quantity);
    }
    public void decrement(View view){//perintah tombol tambah
        if (quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
        display(quantity);
    }


    public void Submitorder(View view) {
        EditText nameEditText=(EditText)findViewById(R.id.edt_name);
        String name=nameEditText.getText().toString();
        Log.v("MainActivity","Nama:"+name);

        CheckBox whippedcreamCheckBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
        boolean haswhippedcream=whippedcreamCheckBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+haswhippedcream);

        CheckBox chocolateCheckBox= (CheckBox) findViewById(R.id.Chocolate_checkbox);
        boolean haschocolate=chocolateCheckBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+haschocolate);

        CheckBox biscuitsCheckBox= (CheckBox) findViewById(R.id.Biscuits_checkbox);
        boolean hasbiscuits=biscuitsCheckBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has chocolate:"+hasbiscuits);

        CheckBox browniesCheckbox= (CheckBox) findViewById(R.id.Brownies_checkbox);
        boolean hasbrownies=browniesCheckbox.isChecked();//mengidentifikasi check
        Log.v("MainActivity", "has biscuits:"+hasbrownies);

        CheckBox GrapesCheckbox= (CheckBox) findViewById(R.id.Grapes_checkbox);
        boolean hasgrapes=GrapesCheckbox.isChecked();//mengidentifikasi check
        Log.v("MainActivity", "has brownies:"+hasgrapes);

        CheckBox nutellaCheckbox= (CheckBox) findViewById(R.id.Nutella_checkbox);
        boolean hasnutella=nutellaCheckbox.isChecked();//mengidentifikasi check
        Log.v("MainActivity", "has grapes:"+hasnutella);

        CheckBox oreoCheckbox= (CheckBox) findViewById(R.id.Oreo_checkbox);
        boolean hasoreo=oreoCheckbox.isChecked();//mengidentifikasi check
        Log.v("MainActivity", "has nutella:"+hasoreo);

        CheckBox cheeseCheckbox= (CheckBox) findViewById(R.id.Cheese_checkbox);
        boolean hascheese=cheeseCheckbox.isChecked();//mengidentifikasi check
        Log.v("MainActivity", "has oreo:"+hascheese);

        CheckBox bubblegumCheckbox= (CheckBox) findViewById(R.id.BubbleGum_checkbox);
        boolean hasbubblegum=bubblegumCheckbox.isChecked();//mengidentifikasi check
        Log.v("MainActivity", "has cheese:"+hasbubblegum);

        CheckBox strawberryCheckbox= (CheckBox) findViewById(R.id.Strawberry_checkbox);
        boolean hasstrawberry=strawberryCheckbox.isChecked();//mengidentifikasi check
        Log.v("MainActivity", "has bubblegum:"+hasstrawberry);

        int price=calculateprice(haswhippedcream,haschocolate);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price,name,haswhippedcream,haschocolate,hasbiscuits,hasbrownies,hasgrapes,hasnutella,hasoreo,hascheese,hasbubblegum,hasstrawberry);


        displayMessage(pricemessage);

    }
    private int calculateprice(boolean addwhipedcream,boolean addchocolate){//jumlah pesanan * harga
        int harga=5000;

        if(addwhipedcream){
            harga=harga+1000;//harga tambahan toping
        }

        if (addchocolate){
            harga=harga+2000;
        }

        return quantity * harga;
    }
    private String createOrderSummary(int price, String name, boolean addChocolate, boolean addWhippedCream, boolean addBiscuits, boolean addBrownies, boolean addGrapes, boolean addNutella, boolean addOreo, boolean addCheese, boolean addBubbleGum, boolean addStrawberry) {//hasil pemesanan
        String pricemessage=" Nama ="+name;
        pricemessage+="\n add Whipped Cream?"+addWhippedCream;
        pricemessage+="\n add Chocolate?"+addChocolate;
        pricemessage+="\n add Biscuits?"+addBiscuits;
        pricemessage+="\n add Brownies?"+addBrownies;
        pricemessage+="\n add Grapes?"+addGrapes;
        pricemessage+="\n add Nutella?"+addNutella;
        pricemessage+="\n add Oreo?"+addOreo;
        pricemessage+="\n add Cheese?"+addCheese;
        pricemessage+="\n add Bubble Gum?"+addBubbleGum;
        pricemessage+="\n add Strawberry?"+addStrawberry;
        pricemessage+="\n quantity"+quantity;
        pricemessage+="\n Total Rp"+price;
        pricemessage+="\n Thankyou";
        return  pricemessage;
    }

    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(message);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}
