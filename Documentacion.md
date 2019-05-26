# Proceso experimental

- Creación de un login básico (MainActivity), el cual tan comprueba que usuario y contraseña son correctos. Inicialmente han sido creados a vacio.

- Grid con los diferentes niveles jugables (LevelsActivity). Además se ha creado una prueba básica en la que enlazamos uno de estos niveles con las siguientes fases. Por lo tanto hay que crear un click para cada uno, con su respectiva carga de la base de datos de las preguntas de dicho nivel.

- Luego nos hemos enfocado en el Navigation Drawer. Para el correcto funcionamiento de este se han creado varias capas, situando en la más superior el drawer con su header y listado (menu), y luego en la más inferior el grid.

	http://www.sgoliver.net/blog/interfaz-de-usuario-en-android-navigation-drawer-navigationview/
	https://code.tutsplus.com/es/tutorials/how-to-code-a-navigation-drawer-in-an-android-app--cms-30263

	- Luego todo esto se ha referenciado desde LevelsActivity, dando especial importancia a los datos que se muestran en el header del Drawer, que para ello hay que tomar los introducidos por el usuario en el login (SharedPreferences). 

	- También se ha creado la funcion que nos permite enlazar cada seccion del listado del drawer con su layout correspondiente. El de about inicialmente.

- Mejora del login / registro.
	
	- Asignar los datos del usuario a SharedPreferences, por lo tanto, si el usuario no está registrado presentar esta pantalla. En caso contrario la de login, y tomar los datos correspondientes en función de ello.
	En definitva hay que rehacer toda la funcionalidad de login - registro siguiendo la siguiente idea:
		- Recuperar los datos de sharedpreferences
		- Si son vacios, registro y añadimos dichos datos. Pensar en el caso de que haya bd......
		- Si ya han sido introducidos, login y validar con la contraseña.

