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
### PUT
```javascript
fetch('http://localhost:8080/api/todo/1', {
    method: 'PUT',
    body: JSON.stringify({
        isDone: true,
        title: 'asdf'
    }),
    headers: {
        'Content-Type': 'application/json'
    },
})
    .then(res => res.json())
    .then(json => console.log(json))
    .catch(e => console.log(e));
```
```
// log
2021-05-30 15:44:06.083 ERROR 1 --- [nio-8080-exec-3] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is java.util.NoSuchElementException: Id fields are different: 1 0
] with root cause
```
