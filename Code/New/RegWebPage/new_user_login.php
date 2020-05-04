<!-- this page will allow for new users to register into the database-->
<!doctype html>
<html>

  <head>
    <title>BlackJack New User</title>
  </head>

  <header>
      <ul class="navBar">
          <li class="navBar"><a href="logout_page.php">Log Out</a></li>
          <li class="navBar"><a href="acct_session.php">Account</a></li>
          <li class="navBar"><a href="new_user_login.php">New User Reg</a></li>
      </ul>
  </header>

  <body>
    <h1>BlackJack New User Registreation</h1>
    <p> Please input the information below to register.</p>

    <form name="log_in" method="post" action="new_user_DB_reg.php">
      Name: <input type="text" name="user_log_in" value="<?php
          echo (isset($user_name) ? htmlspecialchars($user_name) : "");
        ?>"><br>

      Password: <input type="password" name="password" value=""></br></br>
      <input type="submit" name="submit" value="Login"></br>
    </form>
  </body>

</html>