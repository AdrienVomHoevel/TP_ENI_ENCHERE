<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouvelle Vente</title>
</head>
<body>


	<div>


		<div>
			<h3>Nouvelle vente</h3>
		</div>

		<form action="">
			<div>
				<p>
					Article : <input type="text">
				</p>
			</div>
		</form>

		<form action="">
			<div>
				<p>
					Description : <input type="text">
				</p>
			</div>
		</form>

		<label for="list-categorie">Catégorie :</label> <select
			name="categories" id="list-categorie">
			<option value="">---Selectionnez une catégorie---</option>
			<option value="informatique">Informatique</option>
			<option value="ameublement">Ameublement</option>
			<option value="vetement">Vêtement</option>
			<option value="sport&loisirs">Sport & Loisirs</option>
		</select>

		<form action="">
			<div>
				<p>
					Photo de l'article : <input type="file">
				</p>
			</div>
		</form>

		<form action="/action_page.php">
			<label for="Mise à prix">Mise à prix : </label> <input type="number"
				id="miseaprix" name="miseaprix">

		</form>

		<form action="">
			<div>
				<p>
					Début de l'enchère : <input type="date">
				</p>
			</div>
		</form>

		<form action="">
			<div>
				<p>
					Fin de l'enchère : <input type="date">
				</p>
			</div>
		</form>

		<div>
			<p>Retrait</p>

			<div>

				<form action="">
					<div>
						<p>
							Rue : <input type="text">
						</p>
					</div>
				</form>

				<form action="">
					<div>
						<p>
							Code postal : <input type="text">
						</p>
					</div>
				</form>

				<form action="">
					<div>
						<p>
							Ville : <input type="text">
						</p>
					</div>
				</form>

			</div>

		</div>

		<form action="">
			<div>
				<button>Enregistrer</button>
			</div>
		</form>

		<form action="">
			<div>
				<button>Annuler</button>
			</div>
		</form>

		<form action="">
			<div>
				<button>Annuler la vente</button>
			</div>
		</form>

	</div>
</body>
</html>