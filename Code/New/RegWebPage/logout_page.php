
<!--this page will allow logged in users to log out-->

<?php 
   session_start();
   if(!isset($_SESSION['id'])){
       echo "ERROR! No session detected. Page restricted." ;
       include('user_login.php');
       exit();
   }
?>

<!doctype html>
<html>

  <head>
    <title>BlackJack Logout</title>
  </head>

  <header>
      <ul class="navBar">
      <li class="navBar"><a href="logout_page.php">Log Out</a></li>
          <li class="navBar"><a href="acct_session.php">Account</a></li>
          <li class="navBar"><a href="new_user_login.php">New User Reg</a></li>
      </ul>
  </header>

  <body>
    <h1>BlackJack Logout</h1>
    <p>Your data is as follows: <br>
    <br>User Id: <?php echo $_SESSION['id'];?>
    <br>User Name: <?php echo $_SESSION['login_user'];?>
    <br>Account Money: <?php echo $_SESSION['acct_money'];?>
    <br><br>Log out?<br></p>

    <form name="log_out" method="post" action="logout.php">
    <input type="submit" name="submit" value="Log Out"></br>

  </body>

</html>