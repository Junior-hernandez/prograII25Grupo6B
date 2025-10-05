USE ReclutadoraDB;
GO

INSERT INTO Usuarios(Nombre, Email, Contrasenia)
    VALUES('iunior', 'iunior@yo.com', 'pass123');

INSERT INTO RolUsuario(IdRol, IdUsuario)
VALUES(3,2);

INSERT INTO Postulantes(Nombre, Biografia)
VALUES('Junior Hernandez', 'Yo soy yo')

INSERT INTO UsuarioPostulante(IdUsuario, IdPostulante)
VALUES(2,1)