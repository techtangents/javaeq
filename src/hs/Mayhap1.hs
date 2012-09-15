
data Mayhap a = None | Some a

instance Eq a => Eq (Mayhap a) where
  None     == None     = True
  None     == (Some _) = False
  (Some _) == None     = False
  (Some a) == (Some b) = a == b

