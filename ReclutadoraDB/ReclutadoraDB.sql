USE master;
CREATE DATABASE ReclutadoraDB;
GO

USE ReclutadoraDB;
GO

-- SEGURIDAD, ROLES Y PERMISOS DE USUARIOS

    CREATE TABLE Permisos (
        IdPermiso INT PRIMARY KEY IDENTITY(1,1),
        Nombre NVARCHAR(50) NOT NULL,
        Descripcion NVARCHAR(120) NOT NULL,
    );

    CREATE TABLE Roles (
        IdRol INT PRIMARY KEY IDENTITY(1,1),
        Nombre NVARCHAR(50) NOT NULL,
        Descripcion NVARCHAR(120) NOT NULL
    );

    CREATE TABLE RolPermisos(
        IdRolPermiso INT PRIMARY KEY IDENTITY(1,1),
        FK_IdRol INT NOT NULL,
        FK_IdPermiso INT NOT NULL,

        FOREIGN KEY(FK_IdRol) REFERENCES Roles(IdRol),
        FOREIGN KEY(FK_IdPermiso) REFERENCES Permisos(IdPermiso)
    );

    CREATE TABLE Usuarios(
        IdUsuario INT PRIMARY KEY IDENTITY(1,1),
        Nombre NVARCHAR(50) NOT NULL,
        Email NVARCHAR(320) NOT NULL, -- 320 es el limite teorico de caracteres para un e-mail
        Contrasenia NVARCHAR(100) NOT NULL,
        ACTIVO BIT DEFAULT 1
    );

    CREATE TABLE RolUsuarios(
        IdRolUsuario INT PRIMARY KEY IDENTITY(1,1),
        FK_IdRol INT NOT NULL,
        FK_IdUsuario INT NOT NULL,

        FOREIGN KEY(FK_IdRol) REFERENCES Roles(IdRol),
        FOREIGN KEY(FK_IdUsuario) REFERENCES Usuarios(IdUsuario)
    );


-- Empresas y Empleados

    CREATE TABLE Empresas(
        IdEmpresa INT PRIMARY KEY IDENTITY(1,1),
        Nombre NVARCHAR(50) NOT NULL,
        Biografia NVARCHAR(250) NOT NULL,
        Direccion NVARCHAR(120) NOT NULL
    );

    CREATE TABLE UsuarioEmpresas(
        IdUsuarioEmpresa INT PRIMARY KEY IDENTITY(1,1),
        FK_IdUsuario INT NOT NULL,
        FK_IdEmpresa INT NOT NULL,

        FOREIGN KEY(FK_IdUsuario) REFERENCES Usuarios(IdUsuario),
        FOREIGN KEY(FK_IdEmpresa) REFERENCES Empresas(IdEmpresa)
    );


    CREATE TABLE Empleados(
        IdEmpleado INT PRIMARY KEY IDENTITY(1,1),
        Nombre NVARCHAR(50) NOT NULL,
        Biografia NVARCHAR(250) NOT NULL
    );

    CREATE TABLE UsuarioEmpleados(
        IdUsuarioEmpleado INT PRIMARY KEY IDENTITY(1,1),
        FK_IdUsuario INT NOT NULL,
        FK_IdEmpleado INT NOT NULL,

        FOREIGN KEY(FK_IdUsuario) REFERENCES Usuarios(IdUsuario),
        FOREIGN KEY(FK_IdEmpleado) REFERENCES Empleados(IdEmpleado)
    );

    CREATE TABLE Habilidades(
        IdHabilidad INT PRIMARY KEY IDENTITY(1,1),
        Nombre NVARCHAR(50) NOT NULL,
        Descripcion NVARCHAR(120)
    );

    CREATE TABLE HabilidadEmpleados(
        IdHabilidadEmpleado INT PRIMARY KEY IDENTITY(1,1),
        FK_IdHabilidad INT NOT NULL,
        FK_IdEmpleado INT NOT NULL,

        FOREIGN KEY(FK_IdHabilidad) REFERENCES Habilidades(IdHabilidad),
        FOREIGN KEY(FK_IdEmpleado) REFERENCES Empleados(IdEmpleado)
    );

-- Curriculums y Ofertas

    CREATE TABLE Curriculums(
        IdCurriculum INT PRIMARY KEY IDENTITY(1,1),
        FK_IdEmpleado INT NOT NULL,
        Archivo NVARCHAR(120) NOT NULL
    );

    CREATE TABLE Ofertas(
        IdOferta INT PRIMARY KEY IDENTITY(1,1),
        Titulo NVARCHAR(50) NOT NULL,
        Descripcion NVARCHAR(250) NOT NULL,
        Salario DECIMAL(10,2) NOT NULL,
        FK_IdEmpresa INT NOT NULL,

        FOREIGN KEY(FK_IdEmpresa) REFERENCES Empresas(IdEmpresa)
    );

    CREATE TABLE Postulaciones(
        IdPostulacion INT PRIMARY KEY IDENTITY(1,1),
        FK_IdEmpleado INT NOT NULL,
        FK_IdOferta INT NOT NULL,

        FOREIGN KEY (FK_IdEmpleado) REFERENCES Empleados(IdEmpleado),
        FOREIGN KEY (FK_IdOferta) REFERENCES Ofertas(IdOferta)
    );

-- Logs y Bitacora

    CREATE TABLE Bitacoras(
        IdBitacora INT PRIMARY KEY IDENTITY(1,1),
        FechaRegistro DATE DEFAULT GETDATE(),
        FK_IdUsuario INT NOT NULL,
        Accion NVARCHAR(50) NOT NULL,
        Descripcion NVARCHAR(MAX) NOT NULL,

        FOREIGN KEY (FK_IdUsuario) REFERENCES Usuarios(IdUsuario)
    );

    CREATE TABLE Logs(
        IdLog INT PRIMARY KEY IDENTITY(1,1),
        FechaRegistro DATE DEFAULT GETDATE(),
        Error NVARCHAR(50) NOT NULL,
        Descripcion NVARCHAR(MAX) NOT NULL
    );