# Prueba Técnica UI con Serenity BDD
#### Arley Esteban Quintero Amaya - aeqa2000@gmail.com

Este README explica cómo preparar tu entorno en Windows y ejecutar las pruebas UI del repositorio [aeqa2000/prueba-tecnica-ui-serenity](https://github.com/aeqa2000/prueba-tecnica-ui-serenity).

---

## 🛠 Prerrequisitos

Descarga los siguientes paquetes y descomprímelos/instálalos en tu equipo:

| Herramienta      | Versión                | Descripción                             |
|------------------|------------------------|-----------------------------------------|
| **Git**          | 2.49.0 (64-bit)        | Control de versiones                    |
| **Apache Maven** | 3.9.10                 | Gestión de proyectos y dependencias     |
| **Java JDK**     | 17.0.12 (Windows x64)  | Kit de desarrollo de Java               |
| **IntelliJ IDEA**| —                      | *No es necesario para esta guía*        |

> **Ejemplo de rutas de instalación**  
> ```text
> C:\User\Git
> C:\User\apache-maven-3.9.10
> C:\User\jdk-17.0.12
> ```

---

## 🔧 Instalación y configuración

### 1. Java JDK

1. Descomprime el ZIP de JDK 17.0.12 en una carpeta fija.  
   *Ejemplo:* `C:\User\jdk-17.0.12`
2. Configura la variable de entorno **JAVA_HOME**:  
   - **Nombre:** `JAVA_HOME`  
   - **Valor:** `C:\User\jdk-17.0.12`
3. Añade `%JAVA_HOME%\bin` al **PATH** del sistema.

---

### 2. Apache Maven

1. Descomprime el ZIP de Maven 3.9.10 en una carpeta fija.  
   *Ejemplo:* `C:\Herramientas\apache-maven-3.9.10`
2. Configura la variable de entorno **M2_HOME**:  
   - **Nombre:** `M2_HOME`  
   - **Valor:** `C:\Herramientas\apache-maven-3.9.10`
3. Añade `%M2_HOME%\bin` al **PATH** del sistema.

---

### 3. Git

1. Ejecuta el instalador de Git y acepta las opciones por defecto (incluye agregar Git al **PATH**).  
2. Abre **PowerShell** o **CMD** y configura tus credenciales globales:
   ```bash
   git config --global user.name "Tu Nombre"
   git config --global user.email "tu.email@dominio.com"

### ✅ Verificación de la instalación

Abre PowerShell o CMD y ejecuta cada uno de estos comandos. Deben mostrar las versiones correctas:
    ```bash
    java --version
    # Salida esperada: java version "17.0.12"
    mvn --version
    # Salida esperada: Apache Maven 3.9.10 (y que apunte al JAVA_HOME correcto)
    git --version
    # Salida esperada: git version 2.49.0.windows.1 (o similar)

### 🚀 Clonar el repositorio
En tu consola, ve a la carpeta donde quieras alojar tu proyecto y ejecuta:
    ```bash
    git clone https://github.com/aeqa2000/prueba-tecnica-ui-serenity.git

### 🧪 Ejecutar las pruebas
1. Abre PowerShell o CMD.
2. Sitúate en la carpeta raíz del proyecto clonado:
    ```bash
    cd C:\ruta\hacia\prueba-tecnica-ui-serenity
3. Lanza el ciclo de pruebas con Maven:
    ```bash
    mvn clean verify
    
Maven descargará dependencias, compilará el proyecto y ejecutará los tests con Serenity BDD.

### 📊 Acceder al reporte de Serenity
Al finalizar la ejecución, Serenity generará un informe HTML en:
    ```bash
    target/site/serenity/index.html

Para visualizarlo:

1. Abre el Explorador de archivos y navega hasta:
    ```bash
    prueba-tecnica-ui-serenity\target\site\serenity\

2. Haz doble clic en index.html.

3. Explora el reporte en tu navegador, donde encontrarás:
    - Estado de cada escenario
    - Capturas de pantalla
    - Métricas de ejecución
