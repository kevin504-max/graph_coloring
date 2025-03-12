# Diretórios
SRC_DIR = src
OUT_DIR = out

# Pacote principal
PACKAGE = graphcoloring
MAIN_CLASS = Main

# Compilador
JAVAC = javac
JAVA = java

# Opções de compilação
JAVAC_FLAGS = -d $(OUT_DIR)

# Lista de arquivos fonte
SOURCES = $(wildcard $(SRC_DIR)/graphcoloring/*.java)

# Alvo padrão
all: compile

# Compilar os arquivos Java
compile:
	if not exist $(OUT_DIR) mkdir $(OUT_DIR)
	$(JAVAC) $(JAVAC_FLAGS) $(SOURCES)

# Executar o programa
run: compile
	$(JAVA) -cp $(OUT_DIR) $(PACKAGE).$(MAIN_CLASS)

# Limpar arquivos compilados
clean:
	if exist $(OUT_DIR) rmdir /s /q $(OUT_DIR)
