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

    document.forms["signinForm"].action="signUp.html";

  }  // validate various form components