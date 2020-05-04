<?php

//This code will register a new user to the database from new_user_login.php

  $dsn = 'mysql:host=localhost;dbname=ivan_db';
  $db_user = 'ivan_p';
  $db_pass = 'pw';


  if (isset($_POST['user_log_in'])) {
    $user_name = $_POST['user_log_in'];
    $user_log = $_POST['user_log_in'];
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
    include('new_user_login.php');
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
        //*insert*//
        $insert_query = "INSERT INTO new_user (user_name, password) VALUES (:user_name, :input_pass)";
        $stmt = $db->prepare($insert_query);
        $stmt->bindValue(':user_name', $user_name);
        $stmt->bindValue(':input_pass', $input_pass);
        $stmt->execute();
        echo "Congrats! You just registered! Please login below to continue. ";
        include ('user_login.php');
        exit();
        //*insert*//
    } else if ($result['password'] != $input_pass) {
      $error = "Invalid Password";
    } else if ($user_log === $user_name){
        $error = "User already exists";
    }
    else {
      $user_id = (int) $result['user_id'];
      $user_money = (float) $result['money'];
    }

  } catch (PDOException $e) {
    $error = "Can't connect to database: " . $e->getMessage();
    include('new_user_login.php');
    exit(0);
  }

  //error validation
        if (isset($error) && $error !== "") {
            echo "ERROR: " . $error;
            include('new_user_login.php');
            //return to registration page to try again
            exit();
        } else if (isset($user_id)) {
            session_start();
            echo "Congrats!";
            $_SESSION['id'] = $user_id;
            $_SESSION['login_user'] = $user_name;
            $_SESSION['acct_money'] = $user_money;
            include ('successful_login.php');
            exit();
        }

?>