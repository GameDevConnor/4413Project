function validate() {
    var properUsername = /^[a-zA-Z0-9;!-/=?#$%&'*+^_`{|}~,\.]+@[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;

    if (document.forms["signUpForm"]["username"].value == "") {
        alert("username should be filled out");
        document.forms["signUpForm"]["username"].focus();
        return false;
    } // check if the username field is missing
    else if (!document.forms["signUpForm"]["username"].value.match(properUsername)) {
        alert("username format invalid, should be an email address")
        document.forms["signUpForm"]["username"].focus();
        return false;
    } // further check if the username is a valid username format

    if (document.forms["signUpForm"]["password"].value == "") {
        alert("Password should be filled out");
        document.forms["signUpForm"]["password"].focus();
        return false;
    } // check if the Password field is missing

    if (document.forms["signUpForm"]["firstName"].value == "") {
      alert("First name should be filled out");
      document.forms["myForm"]["firstName"].focus();
      return false;
    } // check if the First Name data is missing

    if (document.forms["signUpForm"]["lastName"].value == "") {
        alert("Last name should be filled out");
        document.forms["signUpForm"]["lastName"].focus();
        return false;
    } // check if the Last Name data is missing

	// direct to UserController to insert new user to DB
    document.forms["signUpForm"].action="customers?action=Insert";
  }  // validate various form components