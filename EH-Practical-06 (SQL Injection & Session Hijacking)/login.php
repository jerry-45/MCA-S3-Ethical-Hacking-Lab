<?php
$uname = $_GET['user_name'];
$pass = $_GET['password'];
$servername = 'localhost';
$username = 'root';
$password = '';
$conn = new mysqli($servername, $username, $password, 'ethck');

if($conn -> connect_error){
    die("Connection Failed".$conn->connect_error);
}

$sql = "SELECT * FROM login_details WHERE user_name='$uname' AND password='$pass'";
$result = mysqli_query($conn, $sql);
$check = mysqli_fetch_array($result);

if(isset($check)){
    header("Location: index.html");
}
else{
    echo 'Login Failed';
}
?>

<html>
    <head>
        <title>User Login</title>
        <style>
            body{width: 100vw; height: 100vh; display: flex; justify-content: center; align-items: center; flex-direction: column;}

            form{width: 30%; height: 60%; box-shadow: 8px 8px 8px rgba(0,0,0,0,2), -2px -2px 8px rgba(0,0,0,0,2); display: flex; justify-content: space-evenly; align-items: center; flex-direction: column;}

            .username{display: flex; justify-content: flex-start; align-items: flex-start; flex-direction: column;}

            .username:nth-child(4){flex-direction: row;}

            input[type=text],[type=password]{border: none; border-bottom: 2px solid rgba(0,0,0,0.5); height: 32px; background: rgba(0,0,0,0.1)}

            input[type=submit],[type=reset]{border: none; width: 100px; height: 32px; background: green; color: #fff; margin-left: 0.5rem; border-radius: 6px}

        </style>
    </head>
    <body>
        <form name="FormUser" method="get" action="" align="center">
            <h3 align="center">Login</h3>
            <div class="username">Username<input type="text" name="user_name"></div>
            <div class="username">Password<input type="password" name="password"></div>
            <div class="username">
                <input type="submit" name="Submit" value="Submit">
                <input type="reset">
            </div>
        </form>
    </body>
</html>