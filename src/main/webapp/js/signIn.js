function validate() {
    if (document.forms["signinForm"]["username"].value == "") {
      alert("Username should be filled out");
      document.forms["myForm"]["username"].focus();
      return false;
    } // check if the First Name data is missing

    if (document.forms["signinForm"]["password"].value == "") {
        alert("Password should be filled out");
        document.forms["signinForm"]["password"].focus();
        return false;
    } // check if the Password field is missing

	// Servlet: check credentials in DB and update the action
    //document.forms["signinForm"].action="signUp.html";
    document.forms["signinForm"].action="jsp/shoppingMain.jsp";
    document.forms["signinForm"].method="post";

  }  // validate various form components