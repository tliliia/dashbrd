package com.tronina.dashbrd.exception;

import com.tronina.dashbrd.entity.Status;

public class TaskStatusChangeNotAllowedException extends RuntimeException {
    public TaskStatusChangeNotAllowedException(Long id, Status status) {

        super(String.format("Not available to change status of task (%d) to %s", id, status));
    }
}
