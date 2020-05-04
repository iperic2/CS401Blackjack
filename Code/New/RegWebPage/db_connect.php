<?php

  //this code will connect to mysql db for log-in
  //Note: can change the dbname / db_user / db_pass for final version

  $dsn = 'mysql:host=localhost;dbname=ivan_db';
  $db_user = 'ivan_p';
  $db_pass = 'pw';

  if (isset($_POST['user_log_in'])) {
    $user_name = $_POST['user_log_in'];
  } else {
    $user_name = "";
  }
  if (isset($_POST['password'])) {
    $input_pass = $_POST['password'];
  } else {
    $c = "";
  }

  $error = "";
  if ($user_name === "") {
    $error = "No username given";
  } else if ($input_pass === "") {
    $error = "No password given";
  }
  if ($error !== "") {
    include('user_login.php');
    exit(0);
  }

  // read data from database 
  try {
    $db = new PDO($dsn, $db_user, $db_pass);
    $query = "SELECT password, user_id, money ".
             "FROM new_user ".
             "WHERE user_name = :user_log_in ";
    $stmt = $db->prepare($query);
    $stmt->bindValue('user_log_in', $user_name);
    $stmt->execute();
    $result = $stmt->fetch();
    $stmt->closeCursor();
    if ($result === FALSE) {
      $error = "User not found";
    } else if ($result['password'] != $input_pass) {
      $error = "Invalid Password";
    } else {
      $user_id = (int) $result['user_id'];
      $user_money = (float) $result['money'];
    }
  } catch (PDOException $e) {
    $error = "Can't connect to database: " . $e->getMessage();
    include('user_login.php');
    exit(0);
  }

  //error validation
        if (isset($error) && $error !== "") {
            echo "ERROR: " . $error;
            include('user_login.php');
            //return to registration page to try again
            exit();
        } else if (isset($user_id)) {
            session_start();
            $_SESSION['id'] = $user_id;
            $_SESSION['login_user'] = $user_name;
            $_SESSION['acct_money'] = $user_money;
            include ('successful_login.php');
            exit();
        }

?>
