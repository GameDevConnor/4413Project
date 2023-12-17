function signOut() {
	
	
	// Servlet: go to CustomerControllerForAdmin, sign out, and remove the current session user
    document.forms["signinForm"].action="/4413Project/customers";
    document.forms["signinForm"].method="get";
    

  }