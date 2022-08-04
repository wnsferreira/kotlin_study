# Trabalhar com arquivos

 - FileOutputStream: transferência de dados da aplicação para um arquivo.
 - FileInputStream: transfereência de dados de um arquivo para a aplicação.

### Formas de armazenamento:

 - Interno 
	val fos = this.openFileOutput("texto.txt", MODE_PRIVATE)

 - Externo
	val arquivoCompleto = File(this.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "texto.txt")

 - Cache (caheDir)
	val arquivocompleto = File(this.cacheDir, "texto.txt")
        val fos : FileOutputStream = FileOutputStream(arquivocompleto)