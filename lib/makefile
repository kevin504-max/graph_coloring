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

# Encontrar todos os arquivos .java no diretório src
SOURCES = $(shell find $(SRC_DIR) -name "*.java")

# Alvo padrão
all: compile

# Compilar os arquivos Java
compile:
	mkdir -p $(OUT_DIR)
	$(JAVAC) $(JAVAC_FLAGS) $(SOURCES)

# Executar o programa
run: compile
	$(JAVA) -cp $(OUT_DIR) $(PACKAGE).$(MAIN_CLASS)