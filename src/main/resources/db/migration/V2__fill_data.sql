INSERT INTO public.releases (version, date_start, date_end)
VALUES ('v01', '2023-03-13', '2023-03-19');
INSERT INTO public.releases (version, date_start, date_end)
VALUES ('v02', '2023-03-20', '2023-03-25');

INSERT INTO public.users (LOGIN)
VALUES ('admin');
INSERT INTO public.users (LOGIN)
VALUES ('employee');
INSERT INTO public.users (LOGIN)
VALUES ('second employee');

INSERT INTO public.tasks (release_id, owner_id, title)
VALUES ((SELECT id FROM releases WHERE version = 'v01'),
        (SELECT id FROM users WHERE login = 'admin'),
        'Приложение должно реализовывать перечисленные функции с использованием Spring MVC');
INSERT INTO public.tasks (release_id, owner_id, title)
VALUES ((SELECT id FROM releases WHERE version = 'v01'),
        (SELECT id FROM users WHERE login = 'admin'),
        'Использование паттернов проектирования (разумеется там, где это действительно нужно)');
INSERT INTO public.tasks (release_id, owner_id, title)
VALUES ((SELECT id FROM releases WHERE version = 'v01'),
        (SELECT id FROM users WHERE login = 'admin'),
        'БД должна быть написана с помощью миграций');
INSERT INTO public.tasks (release_id, owner_id, title)
VALUES ((SELECT id FROM releases WHERE version = 'v01'),
        (SELECT id FROM users WHERE login = 'admin'),
        'В приложении все интерфейсы сервисов должны иметь JavaDoc (достаточно на русском языке)');
INSERT INTO public.tasks (release_id, owner_id, title)
VALUES ((SELECT id FROM releases WHERE version = 'v01'),
        (SELECT id FROM users WHERE login = 'admin'),
        'Приложение должно иметь логирование');

INSERT INTO public.tasks (release_id, owner_id, title)
VALUES ((SELECT id FROM releases WHERE version = 'v02'),
        (SELECT id FROM users WHERE login = 'admin'),
        'Приложение предоставляет Swagger API для выполнения предложенных функций');
INSERT INTO public.tasks (release_id, owner_id, title)
VALUES ((SELECT id FROM releases WHERE version = 'v02'),
        (SELECT id FROM users WHERE login = 'admin'),
        'Приложение имеет разграничение по правам доступа');
INSERT INTO public.tasks (release_id, owner_id, title)
VALUES ((SELECT id FROM releases WHERE version = 'v02'),
        (SELECT id FROM users WHERE login = 'admin'),
        'Приложение покрыто юнит-тестами');
INSERT INTO public.tasks (release_id, owner_id, title)
VALUES ((SELECT id FROM releases WHERE version = 'v02'),
        (SELECT id FROM users WHERE login = 'admin'),
        'Приложение использует ресурсные файлы локализации');