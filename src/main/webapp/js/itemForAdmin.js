/**
 * 
 */

 function update(button) {
	    var row = button.closest('tr');
	    
	    var id = document.getElementById("tr-id").value;
		var qty = document.getElementById("tr-qty").value;
	
	    var formHtml = `
	        <form id="updateItem" action="/4413Project/items" method="get">
	            <input type="hidden" name="id" value="${id}">
	            <input type="hidden" name="qty" value="${qty}">
	            
	            <input type="hidden" name="action" value="update">
	            <input type="submit">Update</input>
	        </form>
	    `;
	
	    row.cells[7].innerHTML = formHtml;
	    var updateItem = document.getElementById('updateItem');
        updateItem.submit();
 }

 function insert(button) {
	    var row = button.closest('tr');
	    
	    var id = document.getElementById("id").value;
		var name = document.getElementById("name").value;
		var dsec = document.getElementById("dsec").value;
		var brand = document.getElementById("brand").value;
		var category = document.getElementById("category").value;
		var price = document.getElementById("price").value;
		var qty = document.getElementById("qty").value;
		
		if (id == "" || name == "" || dsec == "" ||  brand == "" || category == "" || price == "" || qty == "") {
        	alert("All fields should be filled out");
	        return false;
    	} // check if any field is missing
	
	    var formHtml = `
	        <form id="addItem" action="/4413Project/items" method="get">
	            <input type="hidden" name="id" value="${id}">
	            <input type="hidden" name="name" value="${name}">
	            <input type="hidden" name="dsec" value="${dsec}">
	            <input type="hidden" name="brand" value="${brand}">
	            <input type="hidden" name="category" value="${category}">
	            <input type="hidden" name="price" value="${price}">
	            <input type="hidden" name="qty" value="${qty}">
	            
	            <input type="hidden" name="action" value="insert">
	            <input type="submit">Add New</input>
	        </form>
	    `;
	
	    row.cells[7].innerHTML = formHtml;
	    var addItem = document.getElementById('addItem');
        addItem.submit();
}