import { render, screen } from '@testing-library/react'
import HomePage from '../pages/HomePage'

test('renderiza el título principal', () => {
  render(<HomePage />)
  expect(screen.getByText('Bienvenido al Sistema de Facturación')).toBeInTheDocument()
})
