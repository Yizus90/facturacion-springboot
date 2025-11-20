import { render, screen } from '@testing-library/react'
import { MemoryRouter } from 'react-router-dom'
import App from '../App'

test('ruta "/" carga HomePage', () => {
  render(
    <MemoryRouter initialEntries={['/']}>
      <App />
    </MemoryRouter>
  )
  expect(screen.getByText(/Bienvenido/i)).toBeInTheDocument()
})

test('ruta "/clientes" carga la página de clientes', () => {
  render(
    <MemoryRouter initialEntries={['/clientes']}>
      <App />
    </MemoryRouter>
  )
  expect(screen.getByText(/Clientes/i)).toBeInTheDocument()
})

test('ruta "/productos" carga la página de productos', () => {
  render(
    <MemoryRouter initialEntries={['/productos']}>
      <App />
    </MemoryRouter>
  )
  expect(screen.getByText(/Productos/i)).toBeInTheDocument()
})