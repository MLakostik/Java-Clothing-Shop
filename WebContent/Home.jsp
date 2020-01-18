<%@ page import="java.util.List, ca.sheridancollege.beans.Product"; %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Clothing Shop</title>
    <link rel="stylesheet" href="styles/style.css">
  </head>
  <body>
  
 
  	
    
    <form class="" action="Cart" method="post">

	<div class="header">
      <img src="images/shopBanner.jpg" alt="">
    </div>
    
    <% //Michael Lakostik | 991515743 | lakostim
    List<Product> productList = (List<Product>) request.getSession().getAttribute("productList");
    
    if(productList == null){
    	out.println("<h2>no items in cart</h2>");
    }else if(productList.size() == 0){
    	out.println("<h2>no items in cart</h2>");
    }else{
    
    	out.println("<h2>Items in Cart: " + productList.size() + "</h2>");
    }
    %>
    
    <h1></h1>
    

    <div class="shopContainer" id="#shopContainer">
      <div class="item" id="item">
        <img src="images/nikeShirt1.jpeg" alt="">
        <h2>Nike T-Shirt (White)</h2>
        <input type="checkbox" name="item" id="NikeShirtWhite" value="Nike,Shirt,White,16.99"> $16.99
      </div>

      <div class="item">
        <img src="images/nikeShirt2.jpeg" alt="">
        <h2>Nike T-Shirt (Black)</h2>
        <input type="checkbox" name="item" id="NikeShirtBlack" value="Nike,Shirt,Black,16.99"> $16.99
      </div>

      <div class="item">
        <img src="images/adidasShirt1.jpeg" alt="">
        <h2>Adidas T-Shirt (Black)</h2>
        <input type="checkbox" name="item" id="AdidasShirtBlack" value="Adidas,Shirt,Black,19.99"> $19.99
      </div>

      <div class="item">
        <img src="images/adidasShirt2.jpeg" alt="">
        <h2>Adidas T-Shirt (Grey)</h2>
        <input type="checkbox" name="item" id="AdidasShirtGrey" value="Adidas,Shirt,Grey,19.99"> $19.99
      </div>

      <div class="item">
        <img src="images/nikeHoodie1.png" alt="">
        <h2>Nike Hoodie (Grey)</h2>
        <input type="checkbox" name="item" id="NikeHoodieGrey" value="Nike,Hoodie,Grey,36.99"> $36.99
      </div>

      <div class="item">
        <img src="images/nikeHoodie2.jpg" alt="">
        <h2>Nike Hoodie (Black)</h2>
        <input type="checkbox" name="item" id="NikeHoodieBlack" value="Nike,Hoodie,Black,36.99"> $36.99
      </div>

      <div class="item">
        <img src="images/adidasHoodie1.jpg" alt="">
        <h2>Adidas Hoodie (Grey)</h2>
        <input type="checkbox" name="item" id="AdidasHoodieGrey" value="Adidas,Hoodie,Grey,36.99"> $36.99
      </div>

      <div class="item">
        <img src="images/adidasHoodie2.jpg" alt="">
        <h2>Adidas Hoodie (Black)</h2>
        <input type="checkbox" name="item" id="AdidasHoodieBlack" value="Adidas,Hoodie,Black,36.99"> $36.99
      </div>

      <div class="item">
        <img src="images/championShirt1.jpg" alt="">
        <h2>Champion T-Shirt (White)</h2>
        <input type="checkbox" name="item" id="ChampionShirtWhite" value="Champion,Shirt,White,21.99"> $21.99
      </div>

      <div class="item">
        <img src="images/championHoodie.jpeg" alt="">
        <h2>Champion Hoodie (White)</h2>
        <input type="checkbox" name="item" id="ChampionHoodieWhite" value="Champion,Hoodie,White,37.99"> $37.99
      </div>

      <div class="item">
        <img src="images/filaHoodie.jpg" alt="">
        <h2>Fila Hoodie</h2>
        <input type="checkbox" name="item" id="FilaHoodieMultiple" value="Fila,Hoodie,Multiple,34.99"> $34.99
      </div>
    </div>

    <div class="cartBox">
      <input class="cartBtn" type="submit" name="" value="Procceed">
    </div>
    
    </form>
    
    <script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
    
    <script>
    var formValues = JSON.parse(localStorage.getItem('formValues')) || {};
    var $checkboxes = $(".item :checkbox");
    var $button = $("#checkbox-container button");

    function allChecked(){
      return $checkboxes.length === $checkboxes.filter(":checked").length;
    }
  
    function updateStorage(){
      $checkboxes.each(function(){
        formValues[this.id] = this.checked;
      });
      localStorage.setItem("formValues", JSON.stringify(formValues));
    }

    $checkboxes.on("change", function(){
      updateStorage();
    });

    // On page load
    $.each(formValues, function(key, value) {
      $("#" + key).prop('checked', value);
    });
    
    </script>
  </body>
</html>
