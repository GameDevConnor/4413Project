function validate() {
	var properUsername = /^[a-zA-Z0-9;!-/=?#$%&'*+^_`{|}~,\.]+@[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	
    if (document.forms["signinForm"]["username"].value == "") {
      alert("Username should be filled out");
      document.forms["signinForm"]["username"].focus();
      return false;
    } // check if the User Name data is missing
    else if (!document.forms["signinForm"]["username"].value.match(properUsername)) {
        alert("Username format invalid, should be an email address")
        document.forms["signInForm"]["username"].focus();
        return false;
    } // further check if the username is a valid username format

    if (document.forms["signinForm"]["password"].value == "") {
        alert("Password should be filled out");
        document.forms["signinForm"]["password"].focus();
        return false;
    } // check if the Password field is missing

	// Servlet: check credentials in DB and update the action
    document.forms["signinForm"].action="/4413Projct/SignIn";
    document.forms["signinForm"].method="get";
    

  }  // validate various form components