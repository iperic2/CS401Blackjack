<!doctype html>
<!-- This page will function as a log-in portal for existing users-->

<html>

  <head>
    <title>BlackJack Log-In</title>
  </head>

  <header>
      <ul class="navBar">
          <li class="navBar"><a href="logout_page.php">Log Out</a></li>
          <li class="navBar"><a href="acct_session.php">Account</a></li>
          <li class="navBar"><a href="new_user_login.php">New User Reg</a></li>
      </ul>
  </header>

  <body>
    <h1>BlackJack Log-In Portal</h1>
    <p>To log in, please enter the username and password you registered with.</p>

    <form name="log_in" method="post" action="db_connect.php">
      Name: <input type="text" name="user_log_in" value="<?php
          echo (isset($user_name) ? htmlspecialchars($user_name) : "");
        ?>"><br>

      Password: <input type="password" name="password" value=""></br></br>
      <input type="submit" name="submit" value="Login"></br>
    </form>
  </body>

</html>