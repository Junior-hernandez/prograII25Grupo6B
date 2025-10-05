USE ReclutadoraDB;
GO
-- SEGURIDAD
    INSERT INTO Permisos (Nombre, Descripcion)
    VALUES
        ('LEER', 'Con este permiso se puede leer registros'),
        ('ESCRIBIR', 'Con este permiso se puede Escribir registros'),
        ('EDITAR', 'Con este permiso se puede Editar registros'),
        ('ELIMINAR', 'Con este permiso se puede Eliminar registros');

    INSERT INTO Roles (Nombre, Descripcion)
    VALUES
        ('ADMIN', 'Con este permiso se puede leer registros'),
        ('EMPRESA', 'Con este permiso se puede Escribir registros'),
        ('POSTULANTE', 'Con este permiso se puede Editar registros');

    INSERT INTO RolPermiso (IdRol, IdPermiso)
    VALUES
        (1,1), (1,2), (1,3), (1,4), -- ADMIN todos los premisos
        (2,1),                      -- EMPRESA solo leer
        (3,1);                      -- POSTULANTE solo leer

    INSERT INTO Usuarios(Nombre, Email, Contrasenia)
        VALUES('admin', 'admin@reclutadora.com', 'password123xd');

    INSERT INTO RolUsuario (IdRol, IdUsuario)
        VALUES(1,1);                        -- Usuario admin, con rol ADMIN
