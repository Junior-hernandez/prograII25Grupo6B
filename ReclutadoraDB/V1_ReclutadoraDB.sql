-- Configuraciones y creación
    USE master;

    CREATE DATABASE ReclutadoraDB;
    GO

    USE ReclutadoraDB;
    GO

-- SEGURIDAD, ROLES Y PERMISOS DE USUARIOS

    CREATE TABLE Permisos (
        IdPermiso INT PRIMARY KEY IDENTITY(1,1),
        Nombre NVARCHAR(50) NOT NULL,
        Descripcion NVARCHAR(120) NOT NULL
    );

    CREATE TABLE Roles (
        IdRol INT PRIMARY KEY IDENTITY(1,1),
        Nombre NVARCHAR(50) NOT NULL,
        Descripcion NVARCHAR(120) NOT NULL
    );

    CREATE TABLE RolPermiso(
        IdRolPermiso INT PRIMARY KEY IDENTITY(1,1),
        IdRol INT NOT NULL,
        IdPermiso INT NOT NULL,

        CONSTRAINT FK_RolPermiso_Roles FOREIGN KEY(IdRol) REFERENCES Roles(IdRol),
        CONSTRAINT FK_RolPermiso_Permisos FOREIGN KEY(IdPermiso) REFERENCES Permisos(IdPermiso),
        CONSTRAINT UQ_RolPermiso_IdRol_IdPermiso UNIQUE(IdRol, IdPermiso)
    );

    CREATE TABLE Usuarios(
        IdUsuario INT PRIMARY KEY IDENTITY(1,1),
        Nombre NVARCHAR(50) NOT NULL,
        Email NVARCHAR(320) NOT NULL , -- 320 es el limite teorico de caracteres para un e-mail
        Contrasenia NVARCHAR(100) NOT NULL,
        Activo BIT DEFAULT 1,

        CONSTRAINT CK_Usuarios_Activo CHECK (Activo IN (0,1)),
        CONSTRAINT UQ_Usuarios_Email UNIQUE (Email)
    );

    CREATE TABLE RolUsuario(
        IdRolUsuario INT PRIMARY KEY IDENTITY(1,1),
        IdRol INT NOT NULL,
        IdUsuario INT NOT NULL,

        CONSTRAINT FK_RolUsuarios_Roles FOREIGN KEY(IdRol) REFERENCES Roles(IdRol),
        CONSTRAINT FK_RolUsuarios_Usuarios FOREIGN KEY(IdUsuario) REFERENCES Usuarios(IdUsuario),
        CONSTRAINT UQ_RolUsuario_IdRol_IdUsuario UNIQUE(IdRol, IdUsuario)
    );

-- Empresas y Postulantes

    CREATE TABLE Empresas(
        IdEmpresa INT PRIMARY KEY IDENTITY(1,1),
        Nombre NVARCHAR(50) NOT NULL,
        Biografia NVARCHAR(250) NOT NULL,
        Direccion NVARCHAR(120) NOT NULL
    );

    CREATE TABLE UsuarioEmpresa(
        IdUsuarioEmpresa INT PRIMARY KEY IDENTITY(1,1),
        IdUsuario INT NOT NULL,
        IdEmpresa INT NOT NULL,

        CONSTRAINT FK_UsuarioEmpresa_Usuarios FOREIGN KEY(IdUsuario) REFERENCES Usuarios(IdUsuario),
        CONSTRAINT FK_UsuarioEmpresa_Empresas FOREIGN KEY(IdEmpresa) REFERENCES Empresas(IdEmpresa),
        CONSTRAINT UQ_UsuarioEmpresa_IdUsuario_IdEmpresa UNIQUE(IdUsuario, IdEmpresa)
    );


    CREATE TABLE Postulantes(
        IdPostulante INT PRIMARY KEY IDENTITY(1,1),
        Nombre NVARCHAR(50) NOT NULL,
        Biografia NVARCHAR(250) NOT NULL
    );

    CREATE TABLE UsuarioPostulante(
        IdUsuarioPostulante INT PRIMARY KEY IDENTITY(1,1),
        IdUsuario INT NOT NULL,
        IdPostulante INT NOT NULL,

        CONSTRAINT FK_UsuarioPostulante_Usuarios FOREIGN KEY(IdUsuario) REFERENCES Usuarios(IdUsuario),
        CONSTRAINT FK_UsuarioPostulante_Postulantes FOREIGN KEY(IdPostulante) REFERENCES Postulantes(IdPostulante),
        CONSTRAINT UQ_UsuarioPostulante_IdUsuario_IdPostulante UNIQUE(IdUsuario, IdPostulante)
    );

    CREATE TABLE Habilidades(
        IdHabilidad INT PRIMARY KEY IDENTITY(1,1),
        Nombre NVARCHAR(50) NOT NULL,
        Descripcion NVARCHAR(120)
    );

    CREATE TABLE HabilidadPostulante(
        IdHabilidadPostulante INT PRIMARY KEY IDENTITY(1,1),
        IdHabilidad INT NOT NULL,
        IdPostulante INT NOT NULL,

        CONSTRAINT FK_HabilidadPostulante_Habilidades FOREIGN KEY(IdHabilidad) REFERENCES Habilidades(IdHabilidad),
        CONSTRAINT FK_HabilidadPostulante_Postulantes FOREIGN KEY(IdPostulante) REFERENCES Postulantes(IdPostulante),
        CONSTRAINT UQ_HabilidadPostulante_IdHabilidad_IdPostulante UNIQUE(IdHabilidad, IdPostulante)
    );

-- Curriculums y Ofertas

    CREATE TABLE Curriculums(
        IdCurriculum INT PRIMARY KEY IDENTITY(1,1),
        IdPostulante INT NOT NULL,
        RutaArchivo NVARCHAR(500) NOT NULL,

        CONSTRAINT FK_Curriculums_Postulantes FOREIGN KEY(IdPostulante) REFERENCES Postulantes(IdPostulante),
        CONSTRAINT UQ_Curriculums_IdPostulante UNIQUE(IdPostulante)
    );

    CREATE TABLE Ofertas(
        IdOferta INT PRIMARY KEY IDENTITY(1,1),
        IdEmpresa INT NOT NULL,
        Titulo NVARCHAR(50) NOT NULL,
        Descripcion NVARCHAR(500) NOT NULL,
        Salario DECIMAL(10,2) NOT NULL,

        CONSTRAINT FK_Ofertas_Empresas FOREIGN KEY(IdEmpresa) REFERENCES Empresas(IdEmpresa),
        CONSTRAINT CK_Ofertas_Salario CHECK (Salario > 0)
    );

    CREATE TABLE Postulaciones(
        IdPostulacion INT PRIMARY KEY IDENTITY(1,1),
        IdPostulante INT NOT NULL,
        IdOferta INT NOT NULL,

        CONSTRAINT FK_Postulaciones_Postulantes FOREIGN KEY (IdPostulante) REFERENCES Postulantes(IdPostulante),
        CONSTRAINT FK_Postulaciones_Ofertas FOREIGN KEY (IdOferta) REFERENCES Ofertas(IdOferta),
        CONSTRAINT UQ_Postulaciones_IdPostulante_IdOferta UNIQUE(IdPostulante, IdOferta)
    );

-- Logs y Bitacora

    CREATE TABLE Bitacoras(
        IdBitacora INT PRIMARY KEY IDENTITY(1,1),
        IdUsuario INT NOT NULL,
        FechaRegistro DATETIME DEFAULT GETDATE(),
        Accion NVARCHAR(100) NOT NULL,
        Descripcion NVARCHAR(250) NOT NULL, 

        CONSTRAINT FK_Bitacoras_Usuarios FOREIGN KEY (IdUsuario) REFERENCES Usuarios(IdUsuario)
    );

    CREATE TABLE Logs(
        IdLog INT PRIMARY KEY IDENTITY(1,1),
        FechaRegistro DATETIME DEFAULT GETDATE(),
        Error NVARCHAR(250) NOT NULL,
        Descripcion NVARCHAR(MAX) NOT NULL -- Max para el Stack Trace
    );