# Conflicto de styles.css — Resolución

## Contexto
Carlos y Sofía modificaron `styles.css` en ramas distintas:
- Carlos (blog) agregó `.blog-highlight`.
- Sofía (calendario) agregó variables `:root`.

## Causa
Ambos tocaron el mismo archivo global, violando la regla de propiedad.

## Resolución (Laura)
1. Se movió `.blog-highlight` a `blog.css` (dueño: Carlos).
2. Se conservaron las variables `:root` en `styles.css` (dueño: Sofía).
3. Se reforzó la regla: **cada uno solo modifica sus propios archivos**.

## Prevención futura
- Sincronización diaria con `main`.
- PR en modo *draft* desde el primer commit.
- `CODEOWNERS` para exigir revisión del dueño por archivo.