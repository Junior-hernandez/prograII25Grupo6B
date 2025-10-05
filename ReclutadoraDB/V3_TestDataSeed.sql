USE ReclutadoraDB;
GO

INSERT INTO Usuarios(Nombre, Email, Contrasenia)
    VALUES
        ('iunior', 'iunior@yo.com', 'pass123'),
        ('Microsoft', 'microsoft@yo.com', 'pass123');


INSERT INTO RolUsuario(IdRol, IdUsuario)
VALUES 
    (3,2),
    (2,3);

INSERT INTO Postulantes(Nombre, Biografia)
VALUES('Junior Hernandez', 'Yo soy yo');

INSERT INTO Empresas (Nombre, Biografia, Direccion)
VALUES ('Microsoft', 'Somos dueños de minecraft', 'Muy lejos de aqui');

INSERT INTO UsuarioPostulante(IdUsuario, IdPostulante)
VALUES(2,1);

INSERT INTO UsuarioEmpresa(IdUsuario, IdEmpresa)
VALUES (3,1)

INSERT INTO Ofertas(IdEmpresa, Titulo, Descripcion, Salario)
VALUES (1, 'Developer', 'Developear', 11500);