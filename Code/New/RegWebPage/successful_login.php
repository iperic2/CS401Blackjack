<!--this page will display after a successful login w a database match
and will fetch data from mysql and display user_id, username, and money in acct.
Also continues a session from db_connect.php-->

<!doctype html>
<html>

  <head>
    <title>Welcome to BlackJack!</title>
  </head>

  <header>
      <ul class="navBar">
          <li class="navBar"><a href="logout_page.php">Log Out</a></li>
          <li class="navBar"><a href="acct_session.php">Account</a></li>
          <li class="navBar"><a href="new_user_page.php">New User Reg</a></li>
      </ul>
  </header>

  <body>
    <h1>Welcome to BlackJack!</h1>
    <p>You have successfully logged in. Your data is as follows: <br>
    <br>User Id: <?php echo ($user_id);?>
    <br>User Name: <?php echo ($user_name);?>
    <br>Account Money: <?php echo ($user_money);?></p>

  </body>

</html>