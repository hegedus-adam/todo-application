# Todo Application

## Prerequisites
### Docker
* https://www.docker.com/get-started
* download and install *docker desktop*
* Afer restart, docker may ask you to install WSL2 Linux kernel
    * do it, follow the link and the 1. point of the instructions

## Start Backend
* `docker build -t todo ./backend`
* `docker container run -p 8080:8080 --name todo todo`

## Usage
### Example
```
// Get all todos
fetch('http://localhost:8080/api/todo')
    .then(res => res.json())
    .then(todos => console.log(todos));
```
### Types
```typescript
interface Todo {
    id: number,
    creationTimeStamp: string,
    isDone: bool,
    title: string
}
```
### Endpoints
* Get all todos:        `GET /api/todo`
* Get todo by id:       `GET /api/todo/:id`
* Update todo by id:    `PUT /api/todo/:id`
* Delete todo by id:    `DELETE /api/todo/:id`
* Save new todo:        `POST /api/todo`

## Bugs
### POST
```javascript
fetch('http://localhost:8080/api/todo', {
        method: 'POST',
        body: {
            isDone: true,
            title: 'asdf'
        },
        headers: {
            'Content-Type': 'application/json'
        },
    })
        .then(res => res.json())
        .then(json => console.log(json[0]))
        .catch(e => console.log(e));
```
```
// log
2021-05-30 15:24:15.839  WARN 1 --- [nio-8080-exec-5] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved [org.springframework.http.converter.HttpMessageNotReadableException: JSON parse error: Cannot deserialize instance of `com.epam.todo.model.ToDo` out of START_ARRAY token; nested exception is com.fasterxml.jackson.databind.exc.MismatchedInputException: Cannot deserialize instance of `com.epam.todo.model.ToDo` out of START_ARRAY token
```

### PUT
```javascript
fetch('http://localhost:8080/api/todo', {
        method: 'PUT',
        body: {
            isDone: true,
            title: 'asdf'
        },
        headers: {
            'Content-Type': 'application/json'
        },
    })
        .then(res => res.json())
        .then(json => console.log(json[0]))
        .catch(e => console.log(e));
```
```
// log
2021-05-30 15:26:13.337  WARN 1 --- [nio-8080-exec-7] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved [org.springframework.web.HttpRequestMethodNotSupportedException: Request method 'PUT' not supported]
```
