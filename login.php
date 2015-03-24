<?php
$con=mysqli_connect("localhost","root","","login");
if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$username = $_GET['username'];
$password = $_GET['password'];
$result = mysqli_query($con,"SELECT username FROM log where Username='$username' and Password='$password'");
$row = mysqli_fetch_array($result);
$data = $row[0];
if($data)
echo "yes";
 else
echo "no";


mysqli_close($con);
?>