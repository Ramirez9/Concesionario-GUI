# Concesionario-GUI

Sobre la versión anterior del Concesionario de coches con excepciones del siguiente repositorio, crea otra versión añadiéndole tanto Ficheros como el entorno gráfico para la comunicación con el usuario. Nos fijaremos en el Notepad para hacerlo lo más parecido posible. 
Con respecto a los ficheros:

 * 1.-Añade un menú Archivo 
 * 2.-Tendrá las opciones típicas: nuevo, abrir, guardar, guardar como...
 * 3.-El concesionario podrá guardarse en un fichero (guardar y guardar como...)
 * 4.-El concesionario podrá leerse de un fichero (abrir)
 * 5.-Podrá crearse un concesionario nuevo (nuevo)
 * 6.-En caso de que se pueda perder información del concesionario, se le preguntará al usuario (nuevo, abrir, guardar como...)
 * 7.-Se le añadirá la extensión ".obj". Deberás utilizar la clase File, que es una representación abstracta de los nombres de         losficheros y directorios. Podrás usar los métodos:

    * 1.- File file = new File(String pathname) 
    * 2.- file.getPath();
    * 3.- file.exists();
    
*PD: Utiliza el ARM para evitar el tener que utilizar el close() de los flujos*
*PPD: Procura colocar la creación del flujo en la misma línea, evitando el uso de variables innecesarias*
Con respecto al GUI:
* 1.-**Paquetes**. Deberás olvidarte del paquete utiles. Necesitas un paquete sólo para el GUI, donde tendrás la clase **Principal.java** que abrirá la ventana principal. Recuerda que las excepciones han de estar en el paquete que las crean.
* 2.-**La página** principal tendrá como título el fichero abierto ("Sin título" en caso de no tener asociado ningún fichero). Será al estilo del Notepad.
* 3.-**Una barra de menú** (JMenuBar) con los siguientes menús (JMenu): Ficheros, Coches, Ayuda. Tendrá las teclas de acceso rápido asociadas a cada elemento del menú, así como mnemotécnicos. Añade también separadores entre elementos del menú. Será al estilo del Notepad. (como en el recurso de los alumnos Juan Antonio Romero y Elisa Navarro)
* 4.-**Un diálogo para trabajar con ficheros** (JFileChooser). Ha de usar un filtro para visualizar los ficheros con extensión ".obj"
* 5.-**Un diálogo para trabajar con Coches** (JDialog). El diálogo contendrá: 
Una caja de texto (JTextField) debidamente etiquetada(JLabel) para las matrículas, Al perder el foco cambiará el color si la matrícula no es válida. Al editar, la matrícula siempre lo hará en negro.
Una lista (JList) para el modelo y otra para la marca. Las listas han de estar sincronizadas.
Tres radio buttons con los tres colores (tres JRadioButton y un ButtonGroup
Selecciona los tres, menú contextual > set ButtonGroup
 con un borde etiquetado Color
Selecciona los tres, menú contextual > Surround with > javax.swing.JPanel border) y 
Botones (JButton) para Salir o realizar la acción (crear, eliminar, mostrar...).
Los mensajes de error (JOptionPane) han de ser lo más conciso posible. Quizás deban basarse en el atributo message de las excepciones.
El menú ayuda dispondrá de un Ver ayuda y Acerca de... 
