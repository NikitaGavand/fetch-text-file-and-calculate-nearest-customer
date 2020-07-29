<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Intercom- Customer processing</title>
</head>
<body style="font-family: arial;">
	<center>
		<form action="customerList" method="post">

			<table style="width: 552px;">
				<thead>
					<tr>
						<h2>Customer radius calculator</h2>
					</tr>
				</thead>
				<tr>
					<td style="width: 213px;">Customer Details Path:</td>
					<td><input type="text" name="fileLink" required="true" /></td>
				</tr>
				<tr>
					<td style="height: 40px;">Latitude:</td>
					<td style="height: 30px;"><input type="number" name="latitude"
						step="any" required="true"  /></td>
				</tr>
				<tr>
					<td>Longitude:</td>
					<td><input type="number" name="longitude" step="any" required="true" /></td>
				</tr>
				<tr style="padding: 20px">
					<td>&nbsp;</td>
					<td><input type="submit" name="getCustomerDet"
						value="Get Customer Details in 100 kms"></td>
				</tr>

			</table>
		</form>
	</center>
</body>

</html>