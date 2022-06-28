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

		<form method="post"
			action="<%=request.getContextPath() %>/routeservletnouvellevente">
			<div>
				<p>
					Article : <input type="text" name="nomArticle">
				</p>
			</div>


			<div>
				<p>
					Description : <input type="text" name="description">
				</p>
			</div>


			<label for="list-categorie">Catégorie :</label> <select
				name="categories" id="list-categorie">
				<option value="">---Selectionnez une catégorie---</option>
				<option value="informatique">Informatique</option>
				<option value="ameublement">Ameublement</option>
				<option value="vetement">Vêtement</option>
				<option value="sport&loisirs">Sport & Loisirs</option>
			</select> Fichiers sélectionnés : <input type="file" name="multiPartServlet"
				accept="image/*" multiple
				onchange="readFilesAndDisplayPreview(this.files);" /> <br /> <input
				type="submit" value="Upload" /> <br />

			<div id="list"></div>



			<label for="miseaprix">Mise à prix : </label> <input type="number"
				id="miseaprix" name="PrixdeMise">




			<div>
				<p>
					Début de l'enchère : <input type="date" name="datedebutenchere">
				</p>
			</div>



			<div>
				<p>
					Fin de l'enchère : <input type="date" name="datefinenchere">
				</p>
			</div>


			<div>
				<p>Retrait</p>
</div>
				<div>

					<div>
						<p>
							Rue : <input type="text" name="rueRetrait">
						</p>
					</div>

					<div>
						<p>
							Code postal : <input type="text" name="codepostal">
						</p>
					</div>

					<div>
						<p>
							Ville : <input type="text" name="ville">
						</p>
					</div>

				</div>

				<div>
					<button>Enregistrer</button>
				</div>

				<div>
					<button>Annuler</button>
				</div>

				<div>
					<button>Annuler la vente</button>
				</div>
		</form>

	</div>
</body>
</html>