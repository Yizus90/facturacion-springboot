import { render, screen } from '@testing-library/react'
import ClientesPage from '../pages/ClientesPage'

test('muestra el título de clientes', () => {
  render(<ClientesPage />)
  expect(screen.getByText(/Listado de Clientes/i)).toBeInTheDocument()
})
