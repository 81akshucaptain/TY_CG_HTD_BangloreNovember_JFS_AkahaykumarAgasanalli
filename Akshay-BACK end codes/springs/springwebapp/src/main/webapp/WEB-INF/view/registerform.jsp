<form action="./registerform" method="post">
	<fieldset>
		<legend>Employee details</legend>
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend>Employee permanent address 1</legend>
		<table>
			<tr>
				<td><select name="addressbean[0].addType">
						<option>--------select----</option>
						<option value="P">permanent</option>
						<option value="T">temporary</option>
				</select></td>
			</tr>
			<tr>
				<td>Address1</td>
				<td><input type="text" name="addressbean[0].address1"></td>
			</tr>
			<tr>
				<td>Address2</td>
				<td><input type="text" name="addressbean[0].address2"></td>
			</tr>
		</table>
	</fieldset>


	<fieldset>
		<legend>Employee temporary address 2</legend>
		<table>
			<tr>
				<td><select name="addressbean[1].addType">
						<option>--------select----</option>
						<option value="P">permanent</option>
						<option value="T">temporary</option>
				</select></td>
			</tr>
			<tr>
				<td>Address1</td>
				<td><input type="text" name="addressbean[1].address1"></td>
			</tr>
			<tr>
				<td>Address2</td>
				<td><input type="text" name="addressbean[1].address2"></td>
			</tr>
		</table>
	</fieldset>
	<table>
		<tr>
			<td><input style="margin-block-start: 30px;" type="submit"
				value="register"></td>
		</tr>
	</table>
</form>


















