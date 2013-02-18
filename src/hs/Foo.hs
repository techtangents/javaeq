module Foo where

{- from Prelude:

class Eq a where
  (==) :: a -> a -> Bool
  (/=) :: a -> a -> Bool

-}

data Foo = Foo String

instance Eq Foo where
  (Foo x) == (Foo y) = x == y

x = Foo "x"
y = Foo "y"
b = x == y

-- compile error - 72 is a numeric type, Foo "x" is not
-- q = Foo "x" == 72
