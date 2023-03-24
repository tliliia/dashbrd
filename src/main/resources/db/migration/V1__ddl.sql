CREATE TABLE public.releases
(
    id              int8    NOT NULL GENERATED ALWAYS AS IDENTITY,
    version         varchar NOT NULL,       --Версия
    date_start      date    NOT NULL,       --Время начала выполнения
    date_end        date    NOT NULL,       --Время завершения работ
    status          varchar NOT NULL DEFAULT 'BACKLOG', -- Статус
    CONSTRAINT releases_pk PRIMARY KEY (id)
);

CREATE TABLE public.users
(
    id         int8    NOT NULL GENERATED ALWAYS AS IDENTITY,
    login      varchar NOT NULL, -- Логин пользователя
    CONSTRAINT users_pk PRIMARY KEY (id)
);

CREATE TABLE public.tasks
(
    id           int8    NOT NULL GENERATED ALWAYS AS IDENTITY,
    title        varchar,                               -- Название задачи
    status       varchar NOT NULL DEFAULT 'BACKLOG',    -- Статус задачи
    release_id   int8    NULL,                          -- Идентификатор релиза
    owner_id     int8    NULL,                          -- Идентификатор создателя задачи
    performer_id int8    NULL,                          -- Идентификатор исполнителя задачи
    CONSTRAINT tasks_pk PRIMARY KEY (id)
);

ALTER TABLE public.tasks ADD CONSTRAINT task_fk_release FOREIGN KEY (release_id) REFERENCES public.releases (id);
ALTER TABLE public.tasks ADD CONSTRAINT task_fk_owner FOREIGN KEY (owner_id) REFERENCES public.users (id);
ALTER TABLE public.tasks ADD CONSTRAINT task_fk_performer FOREIGN KEY (performer_id) REFERENCES public.users (id);
