
<!--this code will delete the log-in session and return to login page-->

<?php
  session_start();
  $_SESSION = array();
  session_destroy();
  include('user_login.php');
  //return to registration page to try again
  exit();
?>